package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * WeChat pay
 * </p>
 */

@TableName("pay_wechat")
public class PayWechat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String outTradeNo; // Merchant Order Number

    private String transactionId; // WeChat Pay Order Number

    private String tradeType;
    // Transaction Type; JSAPI - Public Account Payment, NATIVE - QR Code Payment,
    // APP - APP Payment, MICROPAY - Payment Code Payment, MWEB - H5 Payment, FACEPAY - Face Payment

    private String tradeState;
    // Transaction Status; SUCCESS - Payment Successful,
    // REFUND - Transferred to Refund, NOTPAY - Unpaid, CLOSED - Closed, REVOKED - Revoked (Payment Code Payment), USERPAYING - User is Paying (Payment Code Payment), PAYERROR - Payment Failed (Other reasons, such as bank failure)

    private String tradeStateDesc;
    // Transaction Status Description

    private Integer amount;
    // Total Order Amount; unit: cents

    private Integer payerTotal;
    // User Payment Amount; unit: cents

    private LocalDateTime successTime;
    // Payment Completion Time

    private String payerOpenid; // Payer's User ID; Unique Identifier under the direct merchant appid

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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPayerTotal() {
        return payerTotal;
    }

    public void setPayerTotal(Integer payerTotal) {
        this.payerTotal = payerTotal;
    }

    public LocalDateTime getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(LocalDateTime successTime) {
        this.successTime = successTime;
    }

    public String getPayerOpenid() {
        return payerOpenid;
    }

    public void setPayerOpenid(String payerOpenid) {
        this.payerOpenid = payerOpenid;
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
        return "PayWechat{" +
        "id=" + id +
        ", outTradeNo=" + outTradeNo +
        ", transactionId=" + transactionId +
        ", tradeType=" + tradeType +
        ", tradeState=" + tradeState +
        ", tradeStateDesc=" + tradeStateDesc +
        ", amount=" + amount +
        ", payerTotal=" + payerTotal +
        ", successTime=" + successTime +
        ", payerOpenid=" + payerOpenid +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
