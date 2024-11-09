package io.github.xxyopen.novel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Chapter Publishing Request DTO
 */
@Data
public class ChapterAddReqDto {

    /**
     * Novel ID
     */
    @Schema(description = "Novel ID", required = true)
    private Long bookId;

    /**
     * Chapter Name
     */
    @NotBlank
    @Schema(description = "Chapter Name", required = true)
    private String chapterName;

    /**
     * Chapter Content
     */
    @Schema(description = "Chapter Content", required = true)
    @NotBlank
    @Length(min = 50)
    private String chapterContent;

    /**
     * Is it paid?; 1 - Paid, 0 - Free
     */
    @Schema(description = "Is it paid?; 1 - Paid, 0 - Free", required = true)
    @NotNull
    private Integer isVip;

}

