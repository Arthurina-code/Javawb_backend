package io.github.xxyopen.novel.core.constant;

/**
 * Cache Related Constants
 */
public class CacheConsts {

    /**
     * Redis cache prefix for this project
     */
    public static final String REDIS_CACHE_PREFIX = "Cache::Novel::";

    /**
     * Caffeine cache manager
     */
    public static final String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";

    /**
     * Redis cache manager
     */
    public static final String REDIS_CACHE_MANAGER = "redisCacheManager";

    /**
     * Home page novel recommendation cache
     */
    public static final String HOME_BOOK_CACHE_NAME = "homeBookCache";

    /**
     * Latest news cache
     */
    public static final String LATEST_NEWS_CACHE_NAME = "latestNewsCache";

    /**
     * Novel visit rank cache
     */
    public static final String BOOK_VISIT_RANK_CACHE_NAME = "bookVisitRankCache";

    /**
     * Newest novel rank cache
     */
    public static final String BOOK_NEWEST_RANK_CACHE_NAME = "bookNewestRankCache";

    /**
     * Novel update rank cache
     */
    public static final String BOOK_UPDATE_RANK_CACHE_NAME = "bookUpdateRankCache";

    /**
     * Home page friend link cache
     */
    public static final String HOME_FRIEND_LINK_CACHE_NAME = "homeFriendLinkCache";

    /**
     * Novel category list cache
     */
    public static final String BOOK_CATEGORY_LIST_CACHE_NAME = "bookCategoryListCache";

    /**
     * Novel information cache
     */
    public static final String BOOK_INFO_CACHE_NAME = "bookInfoCache";

    /**
     * Novel chapter cache
     */
    public static final String BOOK_CHAPTER_CACHE_NAME = "bookChapterCache";

    /**
     * Novel content cache
     */
    public static final String BOOK_CONTENT_CACHE_NAME = "bookContentCache";

    /**
     * Recently updated novel ID list cache
     */
    public static final String LAST_UPDATE_BOOK_ID_LIST_CACHE_NAME = "lastUpdateBookIdListCache";

    /**
     * Image verification code cache key
     */
    public static final String IMG_VERIFY_CODE_CACHE_KEY =
            REDIS_CACHE_PREFIX + "imgVerifyCodeCache::";

    /**
     * User information cache
     */
    public static final String USER_INFO_CACHE_NAME = "userInfoCache";

    /**
     * Author information cache
     */
    public static final String AUTHOR_INFO_CACHE_NAME = "authorInfoCache";

    /**
     * Cache configuration constants
     */
    public enum CacheEnum {

        HOME_BOOK_CACHE(0, HOME_BOOK_CACHE_NAME, 60 * 60 * 24, 1),
        LATEST_NEWS_CACHE(0, LATEST_NEWS_CACHE_NAME, 60 * 10, 1),
        BOOK_VISIT_RANK_CACHE(2, BOOK_VISIT_RANK_CACHE_NAME, 60 * 60 * 6, 1),
        BOOK_NEWEST_RANK_CACHE(0, BOOK_NEWEST_RANK_CACHE_NAME, 60 * 30, 1),
        BOOK_UPDATE_RANK_CACHE(0, BOOK_UPDATE_RANK_CACHE_NAME, 60, 1),
        HOME_FRIEND_LINK_CACHE(2, HOME_FRIEND_LINK_CACHE_NAME, 0, 1),
        BOOK_CATEGORY_LIST_CACHE(0, BOOK_CATEGORY_LIST_CACHE_NAME, 0, 2),
        BOOK_INFO_CACHE(0, BOOK_INFO_CACHE_NAME, 60 * 60 * 18, 500),
        BOOK_CHAPTER_CACHE(0, BOOK_CHAPTER_CACHE_NAME, 60 * 60 * 6, 5000),
        BOOK_CONTENT_CACHE(2, BOOK_CONTENT_CACHE_NAME, 60 * 60 * 12, 3000),
        LAST_UPDATE_BOOK_ID_LIST_CACHE(0, LAST_UPDATE_BOOK_ID_LIST_CACHE_NAME, 60 * 60, 10),
        USER_INFO_CACHE(2, USER_INFO_CACHE_NAME, 60 * 60 * 24, 10000),
        AUTHOR_INFO_CACHE(2, AUTHOR_INFO_CACHE_NAME, 60 * 60 * 48, 1000);

        /**
         * Cache type 0 - local, 1 - local and remote, 2 - remote
         */
        private int type;
        /**
         * Cache name
         */
        private String name;
        /**
         * Time-to-live (seconds) 0 - never expires
         */
        private int ttl;
        /**
         * Maximum capacity
         */
        private int maxSize;

        CacheEnum(int type, String name, int ttl, int maxSize) {
            this.type = type;
            this.name = name;
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public boolean isLocal() {
            return type <= 1;
        }

        public boolean isRemote() {
            return type >= 1;
        }

        public String getName() {
            return name;
        }

        public int getTtl() {
            return ttl;
        }

        public int getMaxSize() {
            return maxSize;
        }

    }

}

