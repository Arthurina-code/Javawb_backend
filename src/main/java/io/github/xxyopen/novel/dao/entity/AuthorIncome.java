package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * Royalties Income Statistics
 * </p>
 *

 */
@TableName("author_income")
public class AuthorIncome implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long authorId;

    private Long bookId;

    private LocalDate incomeMonth;


    private Integer preTaxIncome;

    private Integer afterTaxIncome;

    private Integer payStatus;

    /**
     * Royalties Confirmation Status; 0 - Pending Confirmation, 1 - Confirmed
     */
    private Integer confirmStatus;

    private String detail;

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

    public LocalDate getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(LocalDate incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public Integer getPreTaxIncome() {
        return preTaxIncome;
    }

    public void setPreTaxIncome(Integer preTaxIncome) {
        this.preTaxIncome = preTaxIncome;
    }

    public Integer getAfterTaxIncome() {
        return afterTaxIncome;
    }

    public void setAfterTaxIncome(Integer afterTaxIncome) {
        this.afterTaxIncome = afterTaxIncome;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        return "AuthorIncome{" +
        "id=" + id +
        ", authorId=" + authorId +
        ", bookId=" + bookId +
        ", incomeMonth=" + incomeMonth +
        ", preTaxIncome=" + preTaxIncome +
        ", afterTaxIncome=" + afterTaxIncome +
        ", payStatus=" + payStatus +
        ", confirmStatus=" + confirmStatus +
        ", detail=" + detail +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
