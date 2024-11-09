package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Image Verify Code Response DTO
 */
@Data
@Builder
public class ImgVerifyCodeRespDto {

    @Schema(description = "sessionId")
    private String sessionId;

    @Schema(description = "Base64 编码的验证码图片")
    private String img;

}
