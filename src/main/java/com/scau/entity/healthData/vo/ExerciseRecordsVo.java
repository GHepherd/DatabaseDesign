package com.scau.entity.healthData.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.scau.entity.healthData.pojo.ExerciseRecords;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ExerciseRecordsVo {
    private String id;

    private String date;

    private String type="exercise";

    private String note;

    private String exerciseType;


    private Integer duration;

    private BigDecimal distance;

    private BigDecimal calories;

    private Integer heartRate;

    public ExerciseRecordsVo(ExerciseRecords exerciseRecords) {
        id= String.valueOf(exerciseRecords.getExerciseId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date=sdf.format(exerciseRecords.getCreatedAt());
        exerciseType=exerciseRecords.getExerciseType();
        note=exerciseRecords.getNote();
        duration=exerciseRecords.getDurationMinutes();
        distance=exerciseRecords.getDistanceKm();
        calories=exerciseRecords.getCalories();
        heartRate=exerciseRecords.getHeartRate();
    }

}
