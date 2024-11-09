package io.github.xxyopen.novel.core.common.resp;

import io.github.xxyopen.novel.core.common.constant.ErrorCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Objects;

/**
 * HTTP REST Response Utility and Data Format Encapsulation
 */

@Getter
public class RestResp<T> {

    /**
     * Response Code
     */
    @Schema(description = "错误码，00000-没有错误")
    private String code;

    /**
     * Response Message
     */
    @Schema(description = "响应消息")
    private String message;

    /**
     * Response Data
     */
    @Schema(description = "响应数据")
    private T data;

    private RestResp() {
        this.code = ErrorCodeEnum.OK.getCode();
        this.message = ErrorCodeEnum.OK.getMessage();
    }

    private RestResp(ErrorCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    private RestResp(T data) {
        this();
        this.data = data;
    }


    /**
     * Business processing successful, no data returned
     */
    public static RestResp<Void> ok() {
        return new RestResp<>();
    }

    /**
     * Business processing successful, data returned
     */
    public static <T> RestResp<T> ok(T data) {
        return new RestResp<>(data);
    }

    /**
     * Business processing failed
     */
    public static RestResp<Void> fail(ErrorCodeEnum errorCode) {
        return new RestResp<>(errorCode);
    }


    /**
     * System error
     */
    public static RestResp<Void> error() {
        return new RestResp<>(ErrorCodeEnum.SYSTEM_ERROR);
    }

    /**
     * Check if the response indicates success
     */
    public boolean isOk() {
        return Objects.equals(this.code, ErrorCodeEnum.OK.getCode());
    }

}
