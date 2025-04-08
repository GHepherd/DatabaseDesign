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
 * @TableName vital_signs
 */
@TableName(value ="vital_signs")
@Data
public class VitalSigns {
    /**
     * 
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer record_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 身高(cm)
     */
    @TableField(value = "height")
    private BigDecimal height;

    /**
     * 体重(kg)
     */
    @TableField(value = "weight")
    private BigDecimal weight;

    /**
     * 血压(mmHg)
     */
    @TableField(value = "blood_pressure")
    private Integer blood_pressure;

    /**
     * 血糖(mmol/L)
     */
    @TableField(value = "blood_sugar")
    private BigDecimal blood_sugar;

    /**
     * 血脂(mmol/L)
     */
    @TableField(value = "blood_lipids")
    private BigDecimal blood_lipids;

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
        VitalSigns other = (VitalSigns) that;
        return (this.getRecord_id() == null ? other.getRecord_id() == null : this.getRecord_id().equals(other.getRecord_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getBlood_pressure() == null ? other.getBlood_pressure() == null : this.getBlood_pressure().equals(other.getBlood_pressure()))
            && (this.getBlood_sugar() == null ? other.getBlood_sugar() == null : this.getBlood_sugar().equals(other.getBlood_sugar()))
            && (this.getBlood_lipids() == null ? other.getBlood_lipids() == null : this.getBlood_lipids().equals(other.getBlood_lipids()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecord_id() == null) ? 0 : getRecord_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getBlood_pressure() == null) ? 0 : getBlood_pressure().hashCode());
        result = prime * result + ((getBlood_sugar() == null) ? 0 : getBlood_sugar().hashCode());
        result = prime * result + ((getBlood_lipids() == null) ? 0 : getBlood_lipids().hashCode());
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
        sb.append(", record_id=").append(record_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", blood_pressure=").append(blood_pressure);
        sb.append(", blood_sugar=").append(blood_sugar);
        sb.append(", blood_lipids=").append(blood_lipids);
        sb.append(", note=").append(note);
        sb.append(", created_at=").append(created_at);
        sb.append("]");
        return sb.toString();
    }
}