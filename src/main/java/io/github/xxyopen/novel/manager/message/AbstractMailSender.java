package io.github.xxyopen.novel.manager.message;

import io.github.xxyopen.novel.core.config.MailProperties;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * Abstract Email Message Sender
 */
@Slf4j
@RequiredArgsConstructor
public abstract class AbstractMailSender extends AbstractMessageSender {

    private final MailProperties mailProperties;

    private final JavaMailSender mailSender;

    @Override
    protected void sendMessage(Long toUserId, String messageTitle, String messageContent) {
        // TODO Retrieve the email address of the message recipient based on the user ID
        String toEmail = "xxyopen@foxmail.com";
        // Start sending email
        log.info("Starting to send HTML email: {}, {}, {}", toEmail, messageTitle, messageContent);
        // Use MimeMessage, MIME protocol
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        // MimeMessageHelper helps us set richer content
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(mailProperties.username(), mailProperties.nickname(), "UTF-8"));
            helper.setTo(toEmail);
            helper.setSubject(messageTitle);
            // The second parameter true means it supports HTML
            helper.setText(messageContent, true);
            mailSender.send(message);
            log.info("Successfully sent HTML email to {}", toEmail);
        } catch (Exception e) {
            // Email sending failure will not retry
            log.error("Failed to send HTML email to {}", toEmail, e);
        }
    }

}
