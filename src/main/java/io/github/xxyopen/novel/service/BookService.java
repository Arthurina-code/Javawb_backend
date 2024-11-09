package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.req.PageReqDto;
import io.github.xxyopen.novel.core.common.resp.PageRespDto;
import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.BookAddReqDto;
import io.github.xxyopen.novel.dto.req.ChapterAddReqDto;
import io.github.xxyopen.novel.dto.req.ChapterUpdateReqDto;
import io.github.xxyopen.novel.dto.req.UserCommentReqDto;
import io.github.xxyopen.novel.dto.resp.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Book Module Service Interface
 *
 */
public interface BookService {

    /**
     * Query the novel visit ranking
     *
     * @return List of novel visit rankings
     */
    RestResp<List<BookRankRespDto>> listVisitRankBooks();

    /**
     * Query the novel new release ranking
     *
     * @return List of novel new release rankings
     */
    RestResp<List<BookRankRespDto>> listNewestRankBooks();

    /**
     * Query the novel update ranking
     *
     * @return List of novel update rankings
     */
    RestResp<List<BookRankRespDto>> listUpdateRankBooks();

    /**
     * Query novel information
     *
     * @param bookId Novel ID
     * @return Novel information
     */
    RestResp<BookInfoRespDto> getBookById(Long bookId);

    /**
     * Query related information of novel content
     *
     * @param chapterId Chapter ID
     * @return Related information of content
     */
    RestResp<BookContentAboutRespDto> getBookContentAbout(Long chapterId);

    /**
     * Query the latest chapter related information of the novel
     *
     * @param bookId Novel ID
     * @return Related information of chapters
     */
    RestResp<BookChapterAboutRespDto> getLastChapterAbout(Long bookId);

    /**
     * Query the list of recommended novels
     *
     * @param bookId Novel ID
     * @return List of novel information
     */
    RestResp<List<BookInfoRespDto>> listRecBooks(Long bookId) throws NoSuchAlgorithmException;

    /**
     * Increase novel visit count
     *
     * @param bookId Novel ID
     * @return Success status
     */
    RestResp<Void> addVisitCount(Long bookId);

    /**
     * Get the previous chapter ID
     *
     * @param chapterId Chapter ID
     * @return Previous chapter ID
     */
    RestResp<Long> getPreChapterId(Long chapterId);

    /**
     * Get the next chapter ID
     *
     * @param chapterId Chapter ID
     * @return Next chapter ID
     */
    RestResp<Long> getNextChapterId(Long chapterId);

    /**
     * Query the list of novel chapters
     *
     * @param bookId Novel ID
     * @return List of novel chapters
     */
    RestResp<List<BookChapterRespDto>> listChapters(Long bookId);

    /**
     * Query the list of novel categories
     *
     * @param workDirection Work direction; 0 - male, 1 - female
     * @return List of categories
     */
    RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection);

    /**
     * Save a comment
     *
     * @param dto Comment related DTO
     * @return void
     */
    RestResp<Void> saveComment(UserCommentReqDto dto);

    /**
     * Query the latest comments for the novel
     *
     * @param bookId Novel ID
     * @return Latest comment data
     */
    RestResp<BookCommentRespDto> listNewestComments(Long bookId);

    /**
     * Delete a comment
     *
     * @param userId    User ID of the commenter
     * @param commentId Comment ID
     * @return void
     */
    RestResp<Void> deleteComment(Long userId, Long commentId);

    /**
     * Update a comment
     *
     * @param userId  User ID
     * @param id      Comment ID
     * @param content Updated comment content
     * @return void
     */
    RestResp<Void> updateComment(Long userId, Long id, String content);

    /**
     * Save novel information
     *
     * @param dto Novel information
     * @return void
     */
    RestResp<Void> saveBook(BookAddReqDto dto);

    /**
     * Save novel chapter information
     *
     * @param dto Chapter information
     * @return void
     */
    RestResp<Void> saveBookChapter(ChapterAddReqDto dto);

    /**
     * Query the list of novels published by the author
     *
     * @param dto Pagination request parameters
     * @return Paginated list of novel data
     */
    RestResp<PageRespDto<BookInfoRespDto>> listAuthorBooks(PageReqDto dto);

    /**
     * Query the list of chapters published for the novel
     *
     * @param bookId Novel ID
     * @param dto    Pagination request parameters
     * @return Paginated list of chapter data
     */
    RestResp<PageRespDto<BookChapterRespDto>> listBookChapters(Long bookId, PageReqDto dto);

    /**
     * Paginated query of comments
     *
     * @param userId     Member ID
     * @param pageReqDto Pagination parameters
     * @return Paginated list of comments data
     */
    RestResp<PageRespDto<UserCommentRespDto>> listComments(Long userId, PageReqDto pageReqDto);

    /**
     * Delete a novel chapter
     *
     * @param chapterId Chapter ID
     * @return void
     */
    RestResp<Void> deleteBookChapter(Long chapterId);

    /**
     * Query a novel chapter
     *
     * @param chapterId Chapter ID
     * @return Chapter content
     */
    RestResp<ChapterContentRespDto> getBookChapter(Long chapterId);

    /**
     * Update a novel chapter
     *
     * @param chapterId Chapter ID
     * @param dto       Updated content
     * @return void
     */
    RestResp<Void> updateBookChapter(Long chapterId, ChapterUpdateReqDto dto);
}

