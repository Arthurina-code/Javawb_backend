package io.github.xxyopen.novel.core.common.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IpUtils {

    private static final String UNKNOWN_IP = "unknown";

    private static final String IP_SEPARATOR = ",";

    /**
     * Get Real IP
     *
     * @return Real IP
     */
    public String getRealIp(HttpServletRequest request) {
        // This is generally a parameter set by Nginx reverse proxy
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // Handle multiple IPs (only take the first IP)
        if (ip != null && ip.contains(IP_SEPARATOR)) {
            String[] ipArray = ip.split(IP_SEPARATOR);
            ip = ipArray[0];
        }
        return ip;
    }

}
