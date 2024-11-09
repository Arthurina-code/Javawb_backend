package io.github.xxyopen.novel.core.constant;

/**
 * Elasticsearch Related Constants
 */
public class EsConsts {

    private EsConsts() {
        throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
    }

    /**
     * Book Index
     */
    public static class BookIndex {

        private BookIndex() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        /**
         * Index name
         */
        public static final String INDEX_NAME = "book";

        /**
         * ID
         */
        public static final String FIELD_ID = "id";

        /**
         * Work direction; 0 - male audience, 1 - female audience
         */
        public static final String FIELD_WORK_DIRECTION = "workDirection";

        /**
         * Category ID
         */
        public static final String FIELD_CATEGORY_ID = "categoryId";

        /**
         * Category name
         */
        public static final String FIELD_CATEGORY_NAME = "categoryName";

        /**
         * Book name
         */
        public static final String FIELD_BOOK_NAME = "bookName";

        /**
         * Author ID
         */
        public static final String FIELD_AUTHOR_ID = "authorId";

        /**
         * Author name
         */
        public static final String FIELD_AUTHOR_NAME = "authorName";

        /**
         * Book description
         */
        public static final String FIELD_BOOK_DESC = "bookDesc";

        /**
         * Score; total score: 10, actual score = score/10
         */
        public static final String FIELD_SCORE = "score";

        /**
         * Book status; 0 - ongoing, 1 - completed
         */
        public static final String FIELD_BOOK_STATUS = "bookStatus";

        /**
         * Visit count
         */
        public static final String FIELD_VISIT_COUNT = "visitCount";

        /**
         * Total word count
         */
        public static final String FIELD_WORD_COUNT = "wordCount";

        /**
         * Comment count
         */
        public static final String FIELD_COMMENT_COUNT = "commentCount";

        /**
         * Latest chapter ID
         */
        public static final String FIELD_LAST_CHAPTER_ID = "lastChapterId";

        /**
         * Latest chapter name
         */
        public static final String FIELD_LAST_CHAPTER_NAME = "lastChapterName";

        /**
         * Latest chapter update time
         */
        public static final String FIELD_LAST_CHAPTER_UPDATE_TIME = "lastChapterUpdateTime";

        /**
         * Is it paid?; 1 - paid, 0 - free
         */
        public static final String FIELD_IS_VIP = "isVip";

    }

}
