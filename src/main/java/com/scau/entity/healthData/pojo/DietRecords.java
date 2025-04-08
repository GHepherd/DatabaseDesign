package com.scau.entity.healthData.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName diet_records
 */
@TableName(value ="diet_records")
@Data
public class DietRecords {
    /**
     * 
     */
    @TableId(value = "diet_id", type = IdType.AUTO)
    private Integer diet_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "mealTime")
    private Date mealTime;

    /**
     * 食物名称
     */
    @TableField(value = "food_name")
    private String food_name;

    /**
     * 数量(克/毫升)
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 蛋白质
     */
    @TableField(value = "protein")
    private BigDecimal protein;

    /**
     * 碳水化合物
     */
    @TableField(value = "carbs")
    private BigDecimal carbs;

    /**
     * 脂肪
     */
    @TableField(value = "fat")
    private BigDecimal fat;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date created_at;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DietRecords other = (DietRecords) that;
        return (this.getDiet_id() == null ? other.getDiet_id() == null : this.getDiet_id().equals(other.getDiet_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getMealTime() == null ? other.getMealTime() == null : this.getMealTime().equals(other.getMealTime()))
            && (this.getFood_name() == null ? other.getFood_name() == null : this.getFood_name().equals(other.getFood_name()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getProtein() == null ? other.getProtein() == null : this.getProtein().equals(other.getProtein()))
            && (this.getCarbs() == null ? other.getCarbs() == null : this.getCarbs().equals(other.getCarbs()))
            && (this.getFat() == null ? other.getFat() == null : this.getFat().equals(other.getFat()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiet_id() == null) ? 0 : getDiet_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getMealTime() == null) ? 0 : getMealTime().hashCode());
        result = prime * result + ((getFood_name() == null) ? 0 : getFood_name().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getProtein() == null) ? 0 : getProtein().hashCode());
        result = prime * result + ((getCarbs() == null) ? 0 : getCarbs().hashCode());
        result = prime * result + ((getFat() == null) ? 0 : getFat().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", diet_id=").append(diet_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", mealTime=").append(mealTime);
        sb.append(", food_name=").append(food_name);
        sb.append(", amount=").append(amount);
        sb.append(", protein=").append(protein);
        sb.append(", carbs=").append(carbs);
        sb.append(", fat=").append(fat);
        sb.append(", note=").append(note);
        sb.append(", created_at=").append(created_at);
        sb.append("]");
        return sb.toString();
    }
}