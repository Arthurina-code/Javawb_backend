package io.github.xxyopen.novel.core.auth;

import lombok.experimental.UtilityClass;

/**
 * User Information Holder Class
 */

@UtilityClass
public class UserHolder {

    /**
     * Current Thread User ID
     */

    private static final ThreadLocal<Long> userIdTL = new ThreadLocal<>();

    /**
     * Current Thread Writer ID
     */
    private static final ThreadLocal<Long> authorIdTL = new ThreadLocal<>();

    public void setUserId(Long userId) {
        userIdTL.set(userId);
    }

    public Long getUserId() {
        return userIdTL.get();
    }

    public void setAuthorId(Long authorId) {
        authorIdTL.set(authorId);
    }

    public Long getAuthorId() {
        return authorIdTL.get();
    }

    public void clear() {
        userIdTL.remove();
        authorIdTL.remove();
    }

}
