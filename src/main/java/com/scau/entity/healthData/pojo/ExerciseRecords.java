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
 * @TableName exercise_records
 */
@TableName(value ="exercise_records")
@Data
public class ExerciseRecords {
    /**
     * 
     */
    @TableId(value = "exercise_id", type = IdType.AUTO)
    private Integer exercise_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "exercise_type")
    private Object exercise_type;

    /**
     * 运动时长(分钟)
     */
    @TableField(value = "duration_minutes")
    private Integer duration_minutes;

    /**
     * 距离(千米)
     */
    @TableField(value = "distance_km")
    private BigDecimal distance_km;

    /**
     * 消耗卡路里
     */
    @TableField(value = "calories")
    private BigDecimal calories;

    /**
     * 
     */
    @TableField(value = "heartRate")
    private Integer heartRate;

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
        ExerciseRecords other = (ExerciseRecords) that;
        return (this.getExercise_id() == null ? other.getExercise_id() == null : this.getExercise_id().equals(other.getExercise_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getExercise_type() == null ? other.getExercise_type() == null : this.getExercise_type().equals(other.getExercise_type()))
            && (this.getDuration_minutes() == null ? other.getDuration_minutes() == null : this.getDuration_minutes().equals(other.getDuration_minutes()))
            && (this.getDistance_km() == null ? other.getDistance_km() == null : this.getDistance_km().equals(other.getDistance_km()))
            && (this.getCalories() == null ? other.getCalories() == null : this.getCalories().equals(other.getCalories()))
            && (this.getHeartRate() == null ? other.getHeartRate() == null : this.getHeartRate().equals(other.getHeartRate()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExercise_id() == null) ? 0 : getExercise_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getExercise_type() == null) ? 0 : getExercise_type().hashCode());
        result = prime * result + ((getDuration_minutes() == null) ? 0 : getDuration_minutes().hashCode());
        result = prime * result + ((getDistance_km() == null) ? 0 : getDistance_km().hashCode());
        result = prime * result + ((getCalories() == null) ? 0 : getCalories().hashCode());
        result = prime * result + ((getHeartRate() == null) ? 0 : getHeartRate().hashCode());
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
        sb.append(", exercise_id=").append(exercise_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", exercise_type=").append(exercise_type);
        sb.append(", duration_minutes=").append(duration_minutes);
        sb.append(", distance_km=").append(distance_km);
        sb.append(", calories=").append(calories);
        sb.append(", heartRate=").append(heartRate);
        sb.append(", note=").append(note);
        sb.append(", created_at=").append(created_at);
        sb.append("]");
        return sb.toString();
    }
}