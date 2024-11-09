package io.github.xxyopen.novel.manager.message;

/**
 * Message Sender Interface for sending various types of messages
 * <p>
 * Messages are categorized by type, such as system notifications, emails, SMS, and mini-program notifications, and by sending timing,
 * such as registration success messages, recharge success messages, event notification messages, account suspension messages, and novel takedown messages.
 */
public interface MessageSender {

    /**
     * Send a message, supporting dynamic message titles and dynamic message content
     *
     * @param toUserId The user ID of the message recipient
     * @param args     The parameter list used to dynamically generate the message title and message content
     */
    void sendMessage(Long toUserId, Object... args);

}

