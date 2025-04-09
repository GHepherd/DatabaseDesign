package com.scau.entity.healthData.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.scau.entity.healthData.pojo.VitalSigns;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
public class VitalSignsVo {
    private String id;

    private String date;

    private String type="physical";

    private String note;

    private BigDecimal height;

    private BigDecimal weight;

    private Integer bloodPressure;

    private BigDecimal bloodSugar;

    private BigDecimal bloodLipids;

    public VitalSignsVo(VitalSigns vitalSigns) {
        id= String.valueOf(vitalSigns.getRecordId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date= sdf.format(vitalSigns.getCreatedAt());
        note= vitalSigns.getNote();
        height= vitalSigns.getHeight();
        weight= vitalSigns.getWeight();
        bloodPressure= vitalSigns.getBloodPressure();
        bloodSugar= vitalSigns.getBloodSugar();
        bloodLipids= vitalSigns.getBloodLipids();
    }
}
