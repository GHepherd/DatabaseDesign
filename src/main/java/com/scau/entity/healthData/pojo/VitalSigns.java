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
    private Integer id;

    /**
     *
     */
    @TableField(value = "created_at")
    private Date date;

    @TableField(exist = false)
    private String type="physical";

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;
    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

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
    private Integer bloodPressure;

    /**
     * 血糖(mmol/L)
     */
    @TableField(value = "blood_sugar")
    private BigDecimal bloodSugar;

    /**
     * 血脂(mmol/L)
     */
    @TableField(value = "blood_lipids")
    private BigDecimal bloodLipids;




}