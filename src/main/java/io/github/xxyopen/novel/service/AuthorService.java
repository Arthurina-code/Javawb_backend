package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.AuthorRegisterReqDto;

/**
 * Author Module Business Service Interface
 */
public interface AuthorService {

    /**
     * Author registration
     *
     * @param dto Registration parameters
     * @return void
     */
    RestResp<Void> register(AuthorRegisterReqDto dto);

    /**
     * Query author status
     *
     * @param userId User ID
     * @return Author status
     */
    RestResp<Integer> getStatus(Long userId);
}

