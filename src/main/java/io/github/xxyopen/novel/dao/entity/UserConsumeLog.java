package io.github.xxyopen.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * User Consume Log
 * </p>
 *

 */
@TableName("user_consume_log")
public class UserConsumeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId; // Consumer User ID

    private Integer amount; // Amount Consumed; unit: in currency

    private Integer productType; // Type of Product Consumed; 0 - Book VIP Chapter

    private Long productId; // ID of the Consumed Product; e.g., Chapter ID

    private String producName; // Name of the Consumed Product; e.g., Chapter Name

    private Integer producValue; // Value of the Consumed Product; e.g., 1

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

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public Integer getProducValue() {
        return producValue;
    }

    public void setProducValue(Integer producValue) {
        this.producValue = producValue;
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
        return "UserConsumeLog{" +
        "id=" + id +
        ", userId=" + userId +
        ", amount=" + amount +
        ", productType=" + productType +
        ", productId=" + productId +
        ", producName=" + producName +
        ", producValue=" + producValue +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
