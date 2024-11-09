package io.github.xxyopen.novel.core.common.resp;

import java.util.List;
import lombok.Getter;

/**
 * Encapsulation of Paginated Response Data Format
 */
@Getter
public class PageRespDto<T> {


    private final long pageNum;

    private final long pageSize;

    /**
     * Total record count
     */
    private final long total;

    /**
     * Paginated data set
     */
    private final List<? extends T> list;

    /**
     * Constructor used for general paginated query scenarios.
     *  * Accepts standard paginated data and a regular collection.
     */
    public PageRespDto(long pageNum, long pageSize, long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public static <T> PageRespDto<T> of(long pageNum, long pageSize, long total, List<T> list) {
        return new PageRespDto<>(pageNum, pageSize, total, list);
    }

    /**
     * Get the number of pages
     */
    public long getPages() {
        if (this.pageSize == 0L) {
            return 0L;
        } else {
            long pages = this.total / this.pageSize;
            if (this.total % this.pageSize != 0L) {
                ++pages;
            }
            return pages;
        }
    }
}
