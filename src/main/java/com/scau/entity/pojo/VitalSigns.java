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
 * @TableName vital_signs
 */
@TableName(value ="vital_signs")
@Data
public class VitalSigns implements Serializable {
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
     * 
     */
    @TableField(value = "record_date")
    private Date record_date;

    /**
     * 体重(kg)
     */
    @TableField(value = "weight")
    private BigDecimal weight;

    /**
     * 收缩压(mmHg)
     */
    @TableField(value = "blood_pressure_systolic")
    private Integer blood_pressure_systolic;

    /**
     * 舒张压(mmHg)
     */
    @TableField(value = "blood_pressure_diastolic")
    private Integer blood_pressure_diastolic;

    /**
     * 血糖(mmol/L)
     */
    @TableField(value = "blood_glucose")
    private BigDecimal blood_glucose;

    /**
     * 总胆固醇(mmol/L)
     */
    @TableField(value = "cholesterol")
    private BigDecimal cholesterol;

    /**
     * 
     */
    @TableField(value = "recorded_at")
    private Date recorded_at;

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
        VitalSigns other = (VitalSigns) that;
        return (this.getRecord_id() == null ? other.getRecord_id() == null : this.getRecord_id().equals(other.getRecord_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getRecord_date() == null ? other.getRecord_date() == null : this.getRecord_date().equals(other.getRecord_date()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getBlood_pressure_systolic() == null ? other.getBlood_pressure_systolic() == null : this.getBlood_pressure_systolic().equals(other.getBlood_pressure_systolic()))
            && (this.getBlood_pressure_diastolic() == null ? other.getBlood_pressure_diastolic() == null : this.getBlood_pressure_diastolic().equals(other.getBlood_pressure_diastolic()))
            && (this.getBlood_glucose() == null ? other.getBlood_glucose() == null : this.getBlood_glucose().equals(other.getBlood_glucose()))
            && (this.getCholesterol() == null ? other.getCholesterol() == null : this.getCholesterol().equals(other.getCholesterol()))
            && (this.getRecorded_at() == null ? other.getRecorded_at() == null : this.getRecorded_at().equals(other.getRecorded_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecord_id() == null) ? 0 : getRecord_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getRecord_date() == null) ? 0 : getRecord_date().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getBlood_pressure_systolic() == null) ? 0 : getBlood_pressure_systolic().hashCode());
        result = prime * result + ((getBlood_pressure_diastolic() == null) ? 0 : getBlood_pressure_diastolic().hashCode());
        result = prime * result + ((getBlood_glucose() == null) ? 0 : getBlood_glucose().hashCode());
        result = prime * result + ((getCholesterol() == null) ? 0 : getCholesterol().hashCode());
        result = prime * result + ((getRecorded_at() == null) ? 0 : getRecorded_at().hashCode());
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
        sb.append(", record_date=").append(record_date);
        sb.append(", weight=").append(weight);
        sb.append(", blood_pressure_systolic=").append(blood_pressure_systolic);
        sb.append(", blood_pressure_diastolic=").append(blood_pressure_diastolic);
        sb.append(", blood_glucose=").append(blood_glucose);
        sb.append(", cholesterol=").append(cholesterol);
        sb.append(", recorded_at=").append(recorded_at);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}