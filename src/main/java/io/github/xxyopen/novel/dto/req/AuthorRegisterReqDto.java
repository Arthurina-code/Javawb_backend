package io.github.xxyopen.novel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * 作家注册 请求DTO
 */
@Data
public class AuthorRegisterReqDto {

    @Schema(hidden = true)
    private Long userId;

    /**
     * Pen Name
     */
    @Schema(description = "Pen Name", required = true)
    @NotBlank(message = "Pen name cannot be empty!")
    private String penName;

    /**
     * Phone Number
     */
    @Schema(description = "Phone Number", required = true)
    @NotBlank(message = "Phone number cannot be empty!")
    @Pattern(regexp = "^1[3|4|5|6|7|8|9][0-9]{9}$", message = "Invalid phone number format!")
    private String telPhone;

    /**
     * QQ or WeChat Account
     */
    @Schema(description = "QQ or WeChat Account", required = true)
    @NotBlank(message = "QQ or WeChat account cannot be empty!")
    private String chatAccount;

    /**
     * Email Address
     */
    @Schema(description = "Email Address", required = true)
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    /**
     * Work Direction; 0 - Male Audience, 1 - Female Audience
     */
    @Schema(description = "Work Direction; 0 - Male Audience, 1 - Female Audience", required = true)
    @NotNull(message = "Work direction cannot be empty!")
    @Min(0)
    @Max(1)
    private Integer workDirection;

}
