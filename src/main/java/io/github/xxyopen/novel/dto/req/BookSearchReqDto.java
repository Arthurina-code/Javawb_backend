package io.github.xxyopen.novel.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.xxyopen.novel.core.common.req.PageReqDto;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Novel Search Request DTO
 */
@Data
public class BookSearchReqDto extends PageReqDto {

    /**
     * Search Keyword
     */
    @Parameter(description = "Search Keyword")
    private String keyword;

    /**
     * Work Direction
     */
    @Parameter(description = "Work Direction")
    private Integer workDirection;

    /**
     * Category ID
     */
    @Parameter(description = "Category ID")
    private Integer categoryId;

    /**
     * Is it paid?; 1 - Paid, 0 - Free
     */
    @Parameter(description = "Is it paid?; 1 - Paid, 0 - Free")
    private Integer isVip;

    /**
     * Novel Update Status; 0 - Ongoing, 1 - Completed
     */
    @Parameter(description = "Novel Update Status; 0 - Ongoing, 1 - Completed")
    private Integer bookStatus;

    /**
     * Minimum Word Count
     */
    @Parameter(description = "Minimum Word Count")
    private Integer wordCountMin;

    /**
     * Maximum Word Count
     */
    @Parameter(description = "Maximum Word Count")
    private Integer wordCountMax;

    /**
     * Minimum Update Time
     * If using GET requests, use @DateTimeFormat annotation for formatting;
     * If using POST requests, @RequestBody receives request body parameters,
     * the default date format is parsed as yyyy-MM-dd HH:mm:ss.
     * If other date formats need to be received, use @JsonFormat annotation.
     */
    @Parameter(description = "Minimum Update Time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTimeMin;

    /**
     * Sort Field
     */
    @Parameter(description = "Sort Field")
    private String sort;
}

