package io.github.xxyopen.novel.core.constant;

/**
 * System Configuration Related Constants
 */
public class SystemConfigConsts {

    private SystemConfigConsts() {
        throw new IllegalStateException(CONST_INSTANCE_EXCEPTION_MSG);
    }

    /**
     * HTTP request authorization header
     */
    public static final String HTTP_AUTH_HEADER_NAME = "Authorization";

    /**
     * Frontend portal system identifier
     */
    public static final String NOVEL_FRONT_KEY = "front";

    /**
     * Writer management system identifier
     */
    public static final String NOVEL_AUTHOR_KEY = "author";

    /**
     * Backend management system identifier
     */
    public static final String NOVEL_ADMIN_KEY = "admin";

    /**
     * Image upload directory
     */
    public static final String IMAGE_UPLOAD_DIRECTORY = "/image/";

    /**
     * Constant class instantiation exception message
     */
    public static final String CONST_INSTANCE_EXCEPTION_MSG = "Constant class";

}
