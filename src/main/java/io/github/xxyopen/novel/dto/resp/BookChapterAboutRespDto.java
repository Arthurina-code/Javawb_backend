package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Novel Chapter Related Response DTO
 */
@Data
@Builder
public class BookChapterAboutRespDto {

    private BookChapterRespDto chapterInfo;

    /**
     * Total Number of Chapters
     */
    @Schema(description = "Total Number of Chapters")
    private Long chapterTotal;

    /**
     * Content Summary (30 characters)
     */
    @Schema(description = "Content Summary (30 characters)")
    private String contentSummary;

}

