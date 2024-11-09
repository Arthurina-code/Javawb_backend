package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Book Content Response DTO
 */
@Data
@Builder
public class ChapterContentRespDto {

    @Schema(description = "章节名")
    private String chapterName;

    @Schema(description = "章节内容")
    private String chapterContent;

    @Schema(description = "是否收费;1-收费 0-免费")
    private Integer isVip;

}
