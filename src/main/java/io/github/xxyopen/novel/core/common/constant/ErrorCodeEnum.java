package io.github.xxyopen.novel.core.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Error Code Enum Class.
 * <p>
 * The error code is a string type consisting of 5 characters, divided into two parts: source of the error + four-digit number.
 * The source of the error is categorized as A/B/C:
 * - A indicates the error originates from the user, such as parameter errors, outdated user versions, payment timeouts, etc.
 * - B indicates the error originates from the current system, typically due to business logic issues or poor robustness of the program.
 * - C indicates the error originates from third-party services, such as CDN service failures, message delivery timeouts, etc.
 * The four-digit number ranges from 0001 to 9999, with a step interval of 100 reserved between major categories.
 * <p>
 * Error codes are divided into primary macro error codes, secondary macro error codes, and tertiary macro error codes.
 * In cases where a more specific error scenario cannot be determined, primary macro error codes can be used directly.
 */

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    /**
     * Response after successful execution
     */
    OK("00000", "一切 ok"),

    /**
     * Primary Macro Error Code: User-Side Errors
     */
    USER_ERROR("A0001", "用户端错误"),

    /**
     * Secondary Macro Error Code: User Registration Errors
     */
    USER_REGISTER_ERROR("A0100", "用户注册错误"),

    /**
     * User did not agree to the privacy policy
     */
    USER_NO_AGREE_PRIVATE_ERROR("A0101", "用户未同意隐私协议"),

    /**
     * Registration restricted by country or region
     */
    USER_REGISTER_AREA_LIMIT_ERROR("A0102", "注册国家或地区受限"),

    /**
     * Incorrect user verification code
     */
    USER_VERIFY_CODE_ERROR("A0240", "用户验证码错误"),

    /**
     * User Name not Exist
     */
    USER_NAME_EXIST("A0111", "用户名已存在"),

    /**
     * User Account not Exist
     */
    USER_ACCOUNT_NOT_EXIST("A0201", "用户账号不存在"),

    /**
     * User Password is wrong
     */
    USER_PASSWORD_ERROR("A0210", "用户密码错误"),

    /**
     * Secondary Macro Error Code: User Request Parameter Errors
     */
    USER_REQUEST_PARAM_ERROR("A0400", "用户请求参数错误"),

    /**
     * User Login Expired
     */
    USER_LOGIN_EXPIRED("A0230", "用户登录已过期"),

    /**
     * Unauthorized access
     */
    USER_UN_AUTH("A0301", "访问未授权"),

    /**
     * User request service exception
     */
    USER_REQ_EXCEPTION("A0500", "用户请求服务异常"),

    /**
     * Request exceeds the limit
     */
    USER_REQ_MANY("A0501", "请求超出限制"),

    /**
     * User comment exception
     */
    USER_COMMENT("A2000", "用户评论异常"),

    /**
     * User comment uploaded
     */
    USER_COMMENTED("A2001", "用户已发表评论"),

    /**
     * Writer publishment exception
     */
    AUTHOR_PUBLISH("A3000", "作家发布异常"),

    /**
     * Novel name exist
     */
    AUTHOR_BOOK_NAME_EXIST("A3001", "小说名已存在"),

    /**
     * User upload Doc upload exception
     */
    USER_UPLOAD_FILE_ERROR("A0700", "用户上传文件异常"),

    /**
     * User file upload type mismatch
     */
    USER_UPLOAD_FILE_TYPE_NOT_MATCH("A0701", "用户上传文件类型不匹配"),

    /**
     * Primary Macro Error Code: System Execution Errors
     */
    SYSTEM_ERROR("B0001", "系统执行出错"),

    /**
     * Secondary Macro Error Code: System Execution Timeout
     */
    SYSTEM_TIMEOUT_ERROR("B0100", "系统执行超时"),

    /**
     * Primary Macro Error Code: Third-Party Service Invocation Errors
     */
    THIRD_SERVICE_ERROR("C0001", "调用第三方服务出错"),

    /**
     * Primary Macro Error Code: Middleware Service Errors
     */
    MIDDLEWARE_SERVICE_ERROR("C0100", "中间件服务出错");

    /**
     * Error Code
     */
    private final String code;

    /**
     * Chinese description
     */
    private final String message;

}
