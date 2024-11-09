package io.github.xxyopen.novel.core.constant;

/**
 * AMQP Related Constants
 */
public class AmqpConsts {

    /**
     * Book Information Change MQ
     */
    public static class BookChangeMq {

        /**
         * Book Information Change Exchange
         */
        public static final String EXCHANGE_NAME = "EXCHANGE-BOOK-CHANGE";

        /**
         * Elasticsearch book index update queue
         */
        public static final String QUEUE_ES_UPDATE = "QUEUE-ES-BOOK-UPDATE";

        /**
         * Redis book cache update queue
         */
        public static final String QUEUE_REDIS_UPDATE = "QUEUE-REDIS-BOOK-UPDATE";

    }

}
