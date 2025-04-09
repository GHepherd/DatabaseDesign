package com.scau.entity.healthData.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sleep_records
 */
@TableName(value ="sleep_records")
@Data
public class SleepRecords {
    /**
     * 
     */
    @TableId(value = "sleep_id", type = IdType.AUTO)
    private Integer sleepId;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 
     */
    @TableField(value = "sleep_start")
    private Date sleepStart;

    /**
     * 
     */
    @TableField(value = "sleep_end")
    private Date sleepEnd;

    /**
     * 深睡时长(分钟)
     */
    @TableField(value = "deep_sleep_minutes")
    private Integer deepSleepMinutes;

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