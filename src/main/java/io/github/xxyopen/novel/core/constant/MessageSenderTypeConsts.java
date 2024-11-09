package io.github.xxyopen.novel.core.constant;

/**
 * Types of Message Senders
 */
public class MessageSenderTypeConsts {

    private MessageSenderTypeConsts() {
        throw new IllegalStateException("Constant class");
    }

    /**
     * Email sender for successful registration
     */
    public static final String REGISTER_MAIL_SENDER = "registerMailSender";

    /**
     * System notification sender for seckill events
     */
    public static final String SECKILL_SYS_NOTICE_SENDER = "seckillSysNoticeSender";

}
