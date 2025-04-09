package com.scau.entity.healthData.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.scau.entity.healthData.pojo.SleepRecords;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
public class SleepRecordsVo {

    private String id;

    private String date;

    private String type="sleep";

    private String note;

    private String startTime;

    private String endTime;

    private Double quality;

    private Integer deepSleep;

    public SleepRecordsVo(SleepRecords sleepRecords) {
        id= String.valueOf(sleepRecords.getSleepId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date=sdf.format(sleepRecords.getCreatedAt());
        note=sleepRecords.getNote();
        sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        startTime=sdf.format(sleepRecords.getSleepStart());
        endTime=sdf.format(sleepRecords.getSleepEnd());
        long sleepStart = sleepRecords.getSleepStart().getTime();
        long sleepEnd = sleepRecords.getSleepEnd().getTime();
        quality= (double) ((sleepEnd-sleepStart)/3600000);
        deepSleep=sleepRecords.getDeepSleepMinutes();

    }

}
