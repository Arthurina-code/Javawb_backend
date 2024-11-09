package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * User Pay Log
 * </p>
 */
@TableName("user_pay_log")
public class UserPayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId; // Recharge User ID

    private Integer payChannel; // Recharge Method; 0 - Alipay, 1 - WeChat

    private String outTradeNo; // Merchant Order Number

    private Integer amount; // Recharge Amount; unit: cents

    private Integer productType; // Recharge Product Type; 0 - Currency, 1 - Annual VIP

    private Long productId; // Recharge Product ID

    private String productName; // Recharge Product Name; example value: Currency

    private Integer productValue; // Recharge Product Value; example value: 255

    private LocalDateTime payTime; // Recharge Time

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

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductValue() {
        return productValue;
    }

    public void setProductValue(Integer productValue) {
        this.productValue = productValue;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
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
        return "UserPayLog{" +
        "id=" + id +
        ", userId=" + userId +
        ", payChannel=" + payChannel +
        ", outTradeNo=" + outTradeNo +
        ", amount=" + amount +
        ", productType=" + productType +
        ", productId=" + productId +
        ", productName=" + productName +
        ", productValue=" + productValue +
        ", payTime=" + payTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
