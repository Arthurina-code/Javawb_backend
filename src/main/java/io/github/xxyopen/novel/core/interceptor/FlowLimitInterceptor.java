package io.github.xxyopen.novel.core.interceptor;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xxyopen.novel.core.common.constant.ErrorCodeEnum;
import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.core.common.util.IpUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * Flow Limiting Interceptor: Implements interface anti-scraping and rate limiting
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class FlowLimitInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    /**
     * All resources of the novel project
     */
    private static final String NOVEL_RESOURCE = "novelResource";

    static {
        // Rate limiting rule: All requests are limited to a maximum of 2000 QPS, with requests over the limit queued at a steady rate
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule1 = new FlowRule();
        rule1.setResource(NOVEL_RESOURCE);
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 2000.
        rule1.setCount(2000);
        rule1.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
        rules.add(rule1);
        FlowRuleManager.loadRules(rules);

        // Anti-scraping rule 1: Limit each IP to a maximum of 50 requests per second, with requests over the limit directly rejected
        ParamFlowRule rule2 = new ParamFlowRule(NOVEL_RESOURCE)
                .setParamIdx(0)
                .setCount(50);
        // Anti-scraping rule 2: Limit each IP to a maximum of 1000 requests per minute, with requests over the limit directly rejected
        ParamFlowRule rule3 = new ParamFlowRule(NOVEL_RESOURCE)
                .setParamIdx(0)
                .setCount(1000)
                .setDurationInSec(60);
        ParamFlowRuleManager.loadRules(Arrays.asList(rule2, rule3));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String ip = IpUtils.getRealIp(request);
        Entry entry = null;
        try {
            // If exceptions are needed, parameters only support basic types.
            // EntryType represents the flow type, where system rules only apply to IN type entry points.
            // Count is generally set to 1, representing a single call.
            entry = SphU.entry(NOVEL_RESOURCE, EntryType.IN, 1, ip);
            // Your logic here.
            return HandlerInterceptor.super.preHandle(request, response, handler);
        } catch (BlockException ex) {
            // Handle request rejection.
            log.info("IP:{} has been rate-limited!", ip);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter()
                    .write(objectMapper.writeValueAsString(RestResp.fail(ErrorCodeEnum.USER_REQ_MANY)));
        } finally {
            // Note: Always include corresponding parameters in exit to avoid statistical errors.
            if (entry != null) {
                entry.exit(1, ip);
            }
        }
        return false;
    }

}
