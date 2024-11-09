package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.UserInfoUptReqDto;
import io.github.xxyopen.novel.dto.req.UserLoginReqDto;
import io.github.xxyopen.novel.dto.req.UserRegisterReqDto;
import io.github.xxyopen.novel.dto.resp.UserInfoRespDto;
import io.github.xxyopen.novel.dto.resp.UserLoginRespDto;
import io.github.xxyopen.novel.dto.resp.UserRegisterRespDto;

/**
 * Membership Module Service Interface
 *
 */
public interface UserService {

    /**
     * User registration
     *
     * @param dto Registration parameters
     * @return JWT
     */
    RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto);

    /**
     * User login
     *
     * @param dto Login parameters
     * @return JWT + Nickname
     */
    RestResp<UserLoginRespDto> login(UserLoginReqDto dto);

    /**
     * User feedback
     *
     * @param userId  Feedback user ID
     * @param content Feedback content
     * @return void
     */
    RestResp<Void> saveFeedback(Long userId, String content);

    /**
     * Update user information
     *
     * @param dto User information
     * @return void
     */
    RestResp<Void> updateUserInfo(UserInfoUptReqDto dto);

    /**
     * Delete user feedback
     *
     * @param userId User ID
     * @param id     Feedback ID
     * @return void
     */
    RestResp<Void> deleteFeedback(Long userId, Long id);

    /**
     * Query bookshelf status interface
     *
     * @param userId User ID
     * @param bookId Book ID
     * @return 0 - Not on bookshelf, 1 - On bookshelf
     */
    RestResp<Integer> getBookshelfStatus(Long userId, String bookId);

    /**
     * Query user information
     * @param userId User ID
     * @return User information
     */
    RestResp<UserInfoRespDto> getUserInfo(Long userId);
}
