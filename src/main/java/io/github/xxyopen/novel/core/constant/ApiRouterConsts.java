package io.github.xxyopen.novel.core.constant;

/**
 * API Route Constants
 */
public class ApiRouterConsts {

    private ApiRouterConsts() {
        throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
    }

    /**
     * API request path prefix
     */
    public static final String API_URL_PREFIX = "/api";

    /**
     * Frontend portal system request path prefix
     */
    public static final String API_FRONT_URL_PREFIX = API_URL_PREFIX + "/front";

    /**
     * Writer management system request path prefix
     */
    public static final String API_AUTHOR_URL_PREFIX = API_URL_PREFIX + "/author";

    /**
     * Platform backend management system request path prefix
     */
    public static final String API_ADMIN_URL_PREFIX = API_URL_PREFIX + "/admin";

    /**
     * Home module request path prefix
     */
    public static final String HOME_URL_PREFIX = "/home";

    /**
     * News module request path prefix
     */
    public static final String NEWS_URL_PREFIX = "/news";

    /**
     * Novel module request path prefix
     */
    public static final String BOOK_URL_PREFIX = "/book";

    /**
     * Member module request path prefix
     */
    public static final String USER_URL_PREFIX = "/user";

    /**
     * Resource (image/video/document) module request path prefix
     */
    public static final String RESOURCE_URL_PREFIX = "/resource";

    /**
     * Search module request path prefix
     */
    public static final String SEARCH_URL_PREFIX = "/search";

    /**
     * Frontend portal home API request path prefix
     */
    public static final String API_FRONT_HOME_URL_PREFIX = API_FRONT_URL_PREFIX + HOME_URL_PREFIX;

    /**
     * Frontend portal news-related API request path prefix
     */
    public static final String API_FRONT_NEWS_URL_PREFIX = API_FRONT_URL_PREFIX + NEWS_URL_PREFIX;

    /**
     * Frontend portal novel-related API request path prefix
     */
    public static final String API_FRONT_BOOK_URL_PREFIX = API_FRONT_URL_PREFIX + BOOK_URL_PREFIX;

    /**
     * Frontend portal member-related API request path prefix
     */
    public static final String API_FRONT_USER_URL_PREFIX = API_FRONT_URL_PREFIX + USER_URL_PREFIX;

    /**
     * Frontend portal resource (image/video/document) related API request path prefix
     */
    public static final String API_FRONT_RESOURCE_URL_PREFIX =
            API_FRONT_URL_PREFIX + RESOURCE_URL_PREFIX;

    /**
     * Frontend portal search-related API request path prefix
     */
    public static final String API_FRONT_SEARCH_URL_PREFIX =
            API_FRONT_URL_PREFIX + SEARCH_URL_PREFIX;

}
