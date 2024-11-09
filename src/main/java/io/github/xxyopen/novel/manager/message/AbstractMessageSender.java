package io.github.xxyopen.novel.manager.message;

/**
 * Abstract Message Sender
 * <p>
 * Follows the loose coupling design principle, all properties are injected via the constructor to decouple from the Spring framework.
 * <p>
 * All message senders can be registered in the Spring container as a Spring component or used directly by creating new instances.
 * <p>
 * Each type of message may have different sending timing, and the message format may vary based on type and timing, so subclasses will expand on the message format.
 */
public abstract class AbstractMessageSender implements MessageSender {

    private static final String PLACEHOLDER = "{}";

    /**
     * Defines the template for sending messages, subclasses cannot modify this template.
     */
    @Override
    public final void sendMessage(Long toUserId, Object... args) {
        // 1. Get the message title template
        String titleTemplate = getTitleTemplate();
        // 2. Get the message content template
        String contentTemplate = getContentTemplate();
        // 3. Parse the message template to get the final message title to be sent
        String title = resolveTitle(titleTemplate, args);
        // 4. Parse the message content to get the final message content to be sent
        String content = resolveContent(contentTemplate, args);
        // 5. Send the message
        sendMessage(toUserId, title, content);
    }

    /**
     * Send the message; the specific destination is determined by subclasses.
     *
     * @param toUserId       The user ID of the message recipient
     * @param messageTitle   The message title
     * @param messageContent The message content
     */
    protected abstract void sendMessage(Long toUserId, String messageTitle, String messageContent);

    /**
     * Get the message title template; how the template is defined is determined by subclasses.
     *
     * @return The message title template
     */
    protected abstract String getTitleTemplate();

    /**
     * Get the message content template; how the template is defined is determined by subclasses.
     *
     * @return The message content template
     */
    protected abstract String getContentTemplate();

    /**
     * Parse the message title template with the given parameter list; defaults to a fixed title that does not require parsing,
     * but subclasses can extend this functionality.
     *
     * @param titleTemplate The message title template
     * @param arguments     The parameter list for parsing
     * @return The parsed message title
     */
    protected String resolveTitle(String titleTemplate, Object... arguments) {
        return titleTemplate;
    }

    /**
     * Parse the message content template with the given parameter list; the default implementation replaces placeholders in the message content template
     * with the parameter list and can be extended by subclasses.
     * <p>
     * Subclasses can query dynamic content from the database based on the first/few parameters and reorganize the parameter list.
     *
     * @param contentTemplate The message content template
     * @param args            The parameter list for parsing
     * @return The parsed message content
     */
    protected String resolveContent(String contentTemplate, Object... args) {
        if (args.length > 0) {
            StringBuilder formattedContent = new StringBuilder(contentTemplate);
            for (Object arg : args) {
                int start = formattedContent.indexOf(PLACEHOLDER);
                formattedContent.replace(start, start + PLACEHOLDER.length(),
                        String.valueOf(arg));
            }
            return formattedContent.toString();
        }
        return contentTemplate;
    }

}

