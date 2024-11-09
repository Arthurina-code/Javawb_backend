package io.github.xxyopen.novel.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Novel Chapter Response DTO
 */
@Data
@Builder
public class BookChapterRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Chapter ID
     */
    @Schema(description = "Chapter ID")
    private Long id;

    /**
     * Novel ID
     */
    @Schema(description = "Novel ID")
    private Long bookId;

    /**
     * Chapter Number
     */
    @Schema(description = "Chapter Number")
    private Integer chapterNum;

    /**
     * Chapter Name
     */
    @Schema(description = "Chapter Name")
    private String chapterName;

    /**
     * Chapter Word Count
     */
    @Schema(description = "Chapter Word Count")
    private Integer chapterWordCount;

    /**
     * Chapter Update Time
     */
    @Schema(description = "Chapter Update Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime chapterUpdateTime;

    /**
     * Is it paid?; 1 - Paid, 0 - Free
     */
    @Schema(description = "Is it paid?; 1 - Paid, 0 - Free")
    private Integer isVip;

}

