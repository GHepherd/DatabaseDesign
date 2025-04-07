package com.scau.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName diet_records
 */
@TableName(value ="diet_records")
@Data
public class DietRecords implements Serializable {
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
     * 食物名称
     */
    @TableField(value = "food_name")
    private String food_name;

    /**
     * 
     */
    @TableField(value = "meal_type")
    private Object meal_type;

    /**
     * 数量(克/毫升)
     */
    @TableField(value = "quantity")
    private BigDecimal quantity;

    /**
     * 热量(kcal)
     */
    @TableField(value = "calories")
    private BigDecimal calories;

    /**
     * 
     */
    @TableField(value = "record_date")
    private Date record_date;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
            && (this.getFood_name() == null ? other.getFood_name() == null : this.getFood_name().equals(other.getFood_name()))
            && (this.getMeal_type() == null ? other.getMeal_type() == null : this.getMeal_type().equals(other.getMeal_type()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getCalories() == null ? other.getCalories() == null : this.getCalories().equals(other.getCalories()))
            && (this.getRecord_date() == null ? other.getRecord_date() == null : this.getRecord_date().equals(other.getRecord_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiet_id() == null) ? 0 : getDiet_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getFood_name() == null) ? 0 : getFood_name().hashCode());
        result = prime * result + ((getMeal_type() == null) ? 0 : getMeal_type().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getCalories() == null) ? 0 : getCalories().hashCode());
        result = prime * result + ((getRecord_date() == null) ? 0 : getRecord_date().hashCode());
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
        sb.append(", food_name=").append(food_name);
        sb.append(", meal_type=").append(meal_type);
        sb.append(", quantity=").append(quantity);
        sb.append(", calories=").append(calories);
        sb.append(", record_date=").append(record_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}