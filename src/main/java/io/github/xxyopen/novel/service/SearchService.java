package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.PageRespDto;
import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.BookSearchReqDto;
import io.github.xxyopen.novel.dto.resp.BookInfoRespDto;

/**
 * Search Service Interface
 *
 */
public interface SearchService {

    /**
     * Book search
     *
     * @param condition Search conditions
     * @return Search results
     */
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);

}