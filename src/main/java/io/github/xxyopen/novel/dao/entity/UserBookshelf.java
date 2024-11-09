package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * User Bookshelf
 * </p>
 *

 */
@TableName("user_bookshelf")
public class UserBookshelf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // Primary Key

    private Long userId; // User ID

    private Long bookId; // Book ID

    private Long preContentId; // Last Read Chapter Content Table ID

    private LocalDateTime createTime; // Creation Time

    private LocalDateTime updateTime; // Update Time

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getPreContentId() {
        return preContentId;
    }

    public void setPreContentId(Long preContentId) {
        this.preContentId = preContentId;
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
        return "UserBookshelf{" +
        "id=" + id +
        ", userId=" + userId +
        ", bookId=" + bookId +
        ", preContentId=" + preContentId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
