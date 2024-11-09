package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * User Comment Reply
 * </p>
 *

 */
@TableName("user_comment_reply")
public class UserCommentReply implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id; // Primary Key

    private Long commentId; // Comment ID

    private Long userId; // Reply User ID

    private String replyContent; // Reply Content

    private Integer auditStatus; // Audit Status; 0 - Pending Review, 1 - Approved, 2 - Not Approved

    private LocalDateTime createTime; // Creation Time

    private LocalDateTime updateTime; // Update Time

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
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
        return "UserCommentReply{" +
        "id=" + id +
        ", commentId=" + commentId +
        ", userId=" + userId +
        ", replyContent=" + replyContent +
        ", auditStatus=" + auditStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
