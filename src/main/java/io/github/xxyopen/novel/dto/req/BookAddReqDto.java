package io.github.xxyopen.novel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Novel Publishing Request DTO
 */
@Data
public class BookAddReqDto {

    /**
     * Work Direction; 0 - Male Audience, 1 - Female Audience
     */
    @Schema(description = "Work Direction; 0 - Male Audience, 1 - Female Audience", required = true)
    @NotNull
    private Integer workDirection;

    /**
     * Category ID
     */
    @Schema(description = "Category ID", required = true)
    @NotNull
    private Long categoryId;

    /**
     * Category Name
     */
    @Schema(description = "Category Name", required = true)
    @NotBlank
    private String categoryName;

    /**
     * Novel Cover URL
     */
    @Schema(description = "Novel Cover URL", required = true)
    @NotBlank
    private String picUrl;

    /**
     * Novel Name
     */
    @Schema(description = "Novel Name", required = true)
    @NotBlank
    private String bookName;

    /**
     * Book Description
     */
    @Schema(description = "Book Description", required = true)
    @NotBlank
    private String bookDesc;

    /**
     * Is it paid?; 1 - Paid, 0 - Free
     */
    @Schema(description = "Is it paid?; 1 - Paid, 0 - Free", required = true)
    @NotNull
    private Integer isVip;
}

