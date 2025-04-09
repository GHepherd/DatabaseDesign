package com.scau.entity.healthData.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.scau.entity.healthData.pojo.DietRecords;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DietRecordsVo {
    private String id;

    private String date;

    private String type="diet";

    private String note;


    private String mealTime;

    private String foodName;

    private BigDecimal amount;

    private BigDecimal protein;

    private BigDecimal carbs;

    private BigDecimal fat;

    public DietRecordsVo(DietRecords dietRecords) {
        id= String.valueOf(dietRecords.getDietId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date=sdf.format(dietRecords.getCreatedAt());
        note=dietRecords.getNote();
        sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mealTime=sdf.format(dietRecords.getMealTime());
        foodName=dietRecords.getFoodName();
        amount=dietRecords.getAmount();
        protein=dietRecords.getProtein();
        carbs=dietRecords.getCarbs();
        fat=dietRecords.getFat();
    }
}
