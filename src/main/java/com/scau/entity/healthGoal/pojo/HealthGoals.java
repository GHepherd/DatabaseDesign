package com.scau.entity.healthGoal.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName health_goals
 */
@TableName(value ="health_goals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthGoals implements Serializable {
    /**
     * 
     */
    @TableId(value = "goal_id", type = IdType.AUTO)
    private Integer goalId;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 
     */
    @TableField(value = "goal_type")
    private String goalType;


    @TableField(value = "current_value")
    private BigDecimal currentValue;
    /**
     * 目标数值
     */
    @TableField(value = "target_value")
    private BigDecimal targetValue;

    /**
     * 
     */
    @TableField(value = "start_date")
    private Date startDate;

    /**
     * 
     */
    @TableField(value = "end_date")
    private Date endDate;

    /**
     * 
     */
    @TableField(value = "current_progress")
    private Integer currentProgress;

    /**
     * 
     */
    @TableField(value = "status")
    private String status;


    @TableField(value = "title")
    private String title;


    @TableField(value = "note")
    private String note;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}