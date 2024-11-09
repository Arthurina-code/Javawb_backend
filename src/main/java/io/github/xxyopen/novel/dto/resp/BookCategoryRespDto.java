package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Novel Category Response DTO
 */
@Data
@Builder
public class BookCategoryRespDto {

    /**
     * Category ID
     */
    @Schema(description = "Category ID")
    private Long id;

    /**
     * Category Name
     */
    @Schema(description = "Category Name")
    private String name;

}
