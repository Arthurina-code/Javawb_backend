package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * Royalties Income Detail Statistics
 * </p>
 *

 */
@TableName("author_income_detail")
public class AuthorIncomeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long authorId;

    private Long bookId;

    private LocalDate incomeDate;

    private Integer incomeAccount;

    private Integer incomeCount;

    private Integer incomeNumber;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Integer getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(Integer incomeAccount) {
        this.incomeAccount = incomeAccount;
    }

    public Integer getIncomeCount() {
        return incomeCount;
    }

    public void setIncomeCount(Integer incomeCount) {
        this.incomeCount = incomeCount;
    }

    public Integer getIncomeNumber() {
        return incomeNumber;
    }

    public void setIncomeNumber(Integer incomeNumber) {
        this.incomeNumber = incomeNumber;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AuthorIncomeDetail{" +
        "id=" + id +
        ", authorId=" + authorId +
        ", bookId=" + bookId +
        ", incomeDate=" + incomeDate +
        ", incomeAccount=" + incomeAccount +
        ", incomeCount=" + incomeCount +
        ", incomeNumber=" + incomeNumber +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
