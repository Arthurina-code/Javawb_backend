package io.github.xxyopen.novel.core.common.req;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

/**
 * Encapsulation of Paginated Request Data Format.
 * All DTO classes for paginated requests should inherit from this class.
 */
@Data
public class PageReqDto {

    /**
     * Default page number is set to 1.
     */
    @Parameter(description = "请求页码，默认第 1 页")
    private int pageNum = 1;

    /**
     * Default page size is set to 10 items per page.
     */
    @Parameter(description = "每页大小，默认每页 10 条")
    private int pageSize = 10;

    /**
     * Indicates whether to query all records; by default, set to false.
     * When set to true, pageNum and pageSize are ignored.
     */
    @Parameter(hidden = true)
    private boolean fetchAll = false;

}
