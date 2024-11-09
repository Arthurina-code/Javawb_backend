package io.github.xxyopen.novel.manager.message;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Abstract System Notification Sender
 */
@Slf4j
public abstract class AbstractSysNoticeSender extends AbstractMessageSender {

    @Override
    protected void sendMessage(Long toUserId, String messageTitle, String messageContent) {
        // Generate the sending time of the message
        LocalDateTime messageDateTime = LocalDateTime.now();
        // TODO Insert a record into the database system notification table
        log.info("System notification sent successfully: {}, {}, {}, {}", toUserId,
                messageDateTime.format(DateTimeFormatter.ISO_DATE_TIME),
                messageTitle, messageContent);
    }

}

