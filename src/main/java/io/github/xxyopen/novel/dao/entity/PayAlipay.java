package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * Alipay
 * </p>
 *
 */
@TableName("pay_alipay")
public class PayAlipay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String outTradeNo; // Merchant Order Number

    private String tradeNo; // Alipay Transaction Number

    private String buyerId; // Buyer’s Alipay Account ID

    private String tradeStatus; // Transaction Status; TRADE_SUCCESS - Transaction Successful

    private Integer totalAmount; // Order Amount; unit: cents

    private Integer receiptAmount; // Actual Received Amount; unit: cents

    private Integer invoiceAmount; // Invoice Amount

    private LocalDateTime gmtCreate; // Transaction Creation Time

    private LocalDateTime gmtPayment; // Transaction Payment Time

    private LocalDateTime createTime; // Creation Time

    private LocalDateTime updateTime; // Update Time

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Integer receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Integer getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Integer invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(LocalDateTime gmtPayment) {
        this.gmtPayment = gmtPayment;
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
        return "PayAlipay{" +
        "id=" + id +
        ", outTradeNo=" + outTradeNo +
        ", tradeNo=" + tradeNo +
        ", buyerId=" + buyerId +
        ", tradeStatus=" + tradeStatus +
        ", totalAmount=" + totalAmount +
        ", receiptAmount=" + receiptAmount +
        ", invoiceAmount=" + invoiceAmount +
        ", gmtCreate=" + gmtCreate +
        ", gmtPayment=" + gmtPayment +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
