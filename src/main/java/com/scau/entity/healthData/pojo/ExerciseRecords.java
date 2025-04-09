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
    private Integer exerciseId;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 
     */
    @TableField(value = "exercise_type")
    private String exerciseType;

    /**
     * 运动时长(分钟)
     */
    @TableField(value = "duration_minutes")
    private Integer durationMinutes;

    /**
     * 距离(千米)
     */
    @TableField(value = "distance_km")
    private BigDecimal distanceKm;

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
    private Date createdAt;

}