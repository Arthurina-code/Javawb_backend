package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.NewsInfoRespDto;

import java.util.List;

/**
 * News Module Service Interface
 */
public interface NewsService {

    /**
     * Query the latest news list
     *
     * @return List of news
     */
    RestResp<List<NewsInfoRespDto>> listLatestNews();

    /**
     * Query news information
     *
     * @param id News ID
     * @return News information
     */
    RestResp<NewsInfoRespDto> getNews(Long id);
}

