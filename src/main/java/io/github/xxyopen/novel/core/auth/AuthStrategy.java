package io.github.xxyopen.novel.core.auth;

import io.github.xxyopen.novel.core.common.constant.ErrorCodeEnum;
import io.github.xxyopen.novel.core.common.exception.BusinessException;
import io.github.xxyopen.novel.core.constant.SystemConfigConsts;
import io.github.xxyopen.novel.core.util.JwtUtils;
import io.github.xxyopen.novel.dto.UserInfoDto;
import io.github.xxyopen.novel.manager.cache.UserInfoCacheManager;
import java.util.Objects;
import org.springframework.util.StringUtils;

/**
 * Strategy Pattern Implementation for User
 * Authentication and Authorization Functionality
 */

public interface AuthStrategy {

    /**
     * User Authentication and Authorization
     *
     * @param token      Login token
     * @param requestUri Requested URI
     * @throws BusinessException Throws a business exception if authentication fails
     */

    void auth(String token, String requestUri) throws BusinessException;

    /**
     * Frontend Multi-System Single Sign-On Unified Account Authentication and Authorization
     * (for portal system, writer system, and future extensions like comic and video systems)
     *
     * @param jwtUtils             JWT utility
     * @param userInfoCacheManager User cache management object
     * @param token                Login token
     * @return User ID
     */
    default Long authSSO(JwtUtils jwtUtils, UserInfoCacheManager userInfoCacheManager,
        String token) {
        if (!StringUtils.hasText(token)) {
            // token is null
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }
        Long userId = jwtUtils.parseToken(token, SystemConfigConsts.NOVEL_FRONT_KEY);
        if (Objects.isNull(userId)) {
            // token parsing failed
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }
        UserInfoDto userInfo = userInfoCacheManager.getUser(userId);
        if (Objects.isNull(userInfo)) {
            // user does not exist
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }
        // Set userId to the current thread
        UserHolder.setUserId(userId);
        // return userId
        return userId;
    }

}
