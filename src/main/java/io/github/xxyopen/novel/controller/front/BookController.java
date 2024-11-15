package io.github.xxyopen.novel.controller.front;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.core.constant.ApiRouterConsts;
import io.github.xxyopen.novel.dto.resp.BookCategoryRespDto;
import io.github.xxyopen.novel.dto.resp.BookChapterAboutRespDto;
import io.github.xxyopen.novel.dto.resp.BookChapterRespDto;
import io.github.xxyopen.novel.dto.resp.BookCommentRespDto;
import io.github.xxyopen.novel.dto.resp.BookContentAboutRespDto;
import io.github.xxyopen.novel.dto.resp.BookInfoRespDto;
import io.github.xxyopen.novel.dto.resp.BookRankRespDto;
import io.github.xxyopen.novel.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main Portal
 * Novel Module API Controller
 */
@Tag(name = "BookController", description = "前台门户-小说模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_BOOK_URL_PREFIX)
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    /**
     * Search Novel Classification
     */
    @Operation(summary = "小说分类列表查询接口")
    @GetMapping("category/list")
    public RestResp<List<BookCategoryRespDto>> listCategory(
        @Parameter(description = "作品方向", required = true) Integer workDirection) {
        return bookService.listCategory(workDirection);
    }

    /**
     * Search Novel Information
     */
    @Operation(summary = "小说信息查询接口")
    @GetMapping("{id}")
    public RestResp<BookInfoRespDto> getBookById(
        @Parameter(description = "小说 ID") @PathVariable("id") Long bookId) {
        return bookService.getBookById(bookId);
    }

    /**
     * Increase Click Count
     */
    @Operation(summary = "增加小说点击量接口")
    @PostMapping("visit")
    public RestResp<Void> addVisitCount(@Parameter(description = "小说ID") Long bookId) {
        return bookService.addVisitCount(bookId);
    }

    /**
     * Search lastest novel chapter
     */
    @Operation(summary = "小说最新章节相关信息查询接口")
    @GetMapping("last_chapter/about")
    public RestResp<BookChapterAboutRespDto> getLastChapterAbout(
        @Parameter(description = "小说ID") Long bookId) {
        return bookService.getLastChapterAbout(bookId);
    }

    /**
     * Search novel recommended
     */
    @Operation(summary = "小说推荐列表查询接口")
    @GetMapping("rec_list")
    public RestResp<List<BookInfoRespDto>> listRecBooks(
        @Parameter(description = "小说ID") Long bookId) throws NoSuchAlgorithmException {
        return bookService.listRecBooks(bookId);
    }

    /**
     * Search novel chapter
     */
    @Operation(summary = "小说章节列表查询接口")
    @GetMapping("chapter/list")
    public RestResp<List<BookChapterRespDto>> listChapters(
        @Parameter(description = "小说ID") Long bookId) {
        return bookService.listChapters(bookId);
    }

    /**
     * Search Novel content
     */
    @Operation(summary = "小说内容相关信息查询接口")
    @GetMapping("content/{chapterId}")
    public RestResp<BookContentAboutRespDto> getBookContentAbout(
        @Parameter(description = "章节ID") @PathVariable("chapterId") Long chapterId) {
        return bookService.getBookContentAbout(chapterId);
    }

    /**
     * Get last chapter ID
     */
    @Operation(summary = "获取上一章节ID接口")
    @GetMapping("pre_chapter_id/{chapterId}")
    public RestResp<Long> getPreChapterId(
        @Parameter(description = "章节ID") @PathVariable("chapterId") Long chapterId) {
        return bookService.getPreChapterId(chapterId);
    }

    /**
     * Get next chapter ID
     */
    @Operation(summary = "获取下一章节ID接口")
    @GetMapping("next_chapter_id/{chapterId}")
    public RestResp<Long> getNextChapterId(
        @Parameter(description = "章节ID") @PathVariable("chapterId") Long chapterId) {
        return bookService.getNextChapterId(chapterId);
    }

    /**
     * Novel Click Ranking
     */
    @Operation(summary = "小说点击榜查询接口")
    @GetMapping("visit_rank")
    public RestResp<List<BookRankRespDto>> listVisitRankBooks() {
        return bookService.listVisitRankBooks();
    }

    /**
     * Search recentest novel rank
     */
    @Operation(summary = "小说新书榜查询接口")
    @GetMapping("newest_rank")
    public RestResp<List<BookRankRespDto>> listNewestRankBooks() {
        return bookService.listNewestRankBooks();
    }

    /**
     * search updated novel rank
     */
    @Operation(summary = "小说更新榜查询接口")
    @GetMapping("update_rank")
    public RestResp<List<BookRankRespDto>> listUpdateRankBooks() {
        return bookService.listUpdateRankBooks();
    }

    /**
     * search newest list of novel comment
     */
    @Operation(summary = "小说最新评论查询接口")
    @GetMapping("comment/newest_list")
    public RestResp<BookCommentRespDto> listNewestComments(
        @Parameter(description = "小说ID") Long bookId) {
        return bookService.listNewestComments(bookId);
    }

}
