package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.HomeBookRespDto;
import io.github.xxyopen.novel.dto.resp.HomeFriendLinkRespDto;

import java.util.List;
/**
 * Home Module Service Interface
 */
public interface HomeService {

    /**
     * Query the list of recommended novels for the homepage
     *
     * @return REST response result of the recommended novels list for the homepage
     */
    RestResp<List<HomeBookRespDto>> listHomeBooks();

    /**
     * Query the list of homepage friend links
     *
     * @return List of friend links
     */
    RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks();
}
