package io.github.xxyopen.novel.controller.front;

import io.github.xxyopen.novel.core.constant.ApiRouterConsts;
import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.HomeBookRespDto;
import io.github.xxyopen.novel.dto.resp.HomeFriendLinkRespDto;
import io.github.xxyopen.novel.service.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Main Portal
 * HomePage Module API Controller
 */
@Tag(name = "HomeController", description = "前台门户-首页模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_HOME_URL_PREFIX)
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    /**
     * novel recommended on homepage
     */
    @Operation(summary = "首页小说推荐查询接口")
    @GetMapping("books")
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return homeService.listHomeBooks();
    }

    /**
     * friend link on homepage
     */
    @Operation(summary = "首页友情链接列表查询接口")
    @GetMapping("friend_Link/list")
    public RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks() {
        return homeService.listHomeFriendLinks();
    }

}
