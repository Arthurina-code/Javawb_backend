package io.github.xxyopen.novel.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.xxyopen.novel.dao.entity.BookInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xxyopen.novel.dto.req.BookSearchReqDto;
import io.github.xxyopen.novel.dto.resp.BookInfoRespDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Book Info Mapper Interface
 * </p>
 *

 */
public interface BookInfoMapper extends BaseMapper<BookInfo> {

    /**
     * 增加小说点击量
     *
     * @param bookId 小说ID
     */
    void addVisitCount(@Param("bookId") Long bookId);

    /**
     * 小说搜索
     * @param page mybatis-plus 分页对象
     * @param condition 搜索条件
     * @return 返回结果
     * */
    List<BookInfo> searchBooks(IPage<BookInfoRespDto> page, BookSearchReqDto condition);

}
