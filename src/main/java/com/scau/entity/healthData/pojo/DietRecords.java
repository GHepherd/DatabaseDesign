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
    private Integer dietId;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 
     */
    @TableField(value = "mealTime")
    private Date mealTime;

    /**
     * 食物名称
     */
    @TableField(value = "food_name")
    private String foodName;

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
    private Date createdAt;

}