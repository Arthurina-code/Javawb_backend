package io.github.xxyopen.novel.dto.es;

import io.github.xxyopen.novel.dao.entity.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;

/**
 *DTO for Storing Novels in Elasticsearch
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EsBookDto {

    private Long id;

    private Integer workDirection; // Work Direction; 0 - Male Audience, 1 - Female Audience

    private Long categoryId; // Category ID

    private String categoryName; // Category Name

    private String bookName; // Novel Name

    private Long authorId; // Author ID

    private String authorName; // Author Name

    private String bookDesc; // Book Description

    private Integer score; // Rating; Total Score: 10, Actual Rating = score/10

    private Integer bookStatus; // Book Status; 0 - Ongoing, 1 - Completed

    private Long visitCount; // Visit Count

    private Integer wordCount; // Total Word Count

    private Integer commentCount; // Comment Count

    private Long lastChapterId; // Latest Chapter ID

    private String lastChapterName; // Latest Chapter Name

    private Long lastChapterUpdateTime; // Latest Chapter Update Time

    private Integer isVip; // Is it Paid?; 1 - Paid, 0 - Free

    public static EsBookDto build(BookInfo bookInfo){
        return EsBookDto.builder()
                .id(bookInfo.getId())
                .categoryId(bookInfo.getCategoryId())
                .categoryName(bookInfo.getCategoryName())
                .bookDesc(bookInfo.getBookDesc())
                .bookName(bookInfo.getBookName())
                .authorId(bookInfo.getAuthorId())
                .authorName(bookInfo.getAuthorName())
                .bookStatus(bookInfo.getBookStatus())
                .commentCount(bookInfo.getCommentCount())
                .isVip(bookInfo.getIsVip())
                .score(bookInfo.getScore())
                .visitCount(bookInfo.getVisitCount())
                .wordCount(bookInfo.getWordCount())
                .workDirection(bookInfo.getWorkDirection())
                .lastChapterId(bookInfo.getLastChapterId())
                .lastChapterName(bookInfo.getLastChapterName())
                .lastChapterUpdateTime(bookInfo.getLastChapterUpdateTime()
                        .toInstant(ZoneOffset.ofHours(8)).toEpochMilli())
                .build();
    }

}
