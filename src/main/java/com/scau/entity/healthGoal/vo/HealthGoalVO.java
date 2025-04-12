package com.scau.entity.healthGoal.vo;

import lombok.Data;

@Data
public class HealthGoalVO {

    private String id;

    private String title;

    private String type;

    private Long target;

    private Integer currentProgress;

    private String startDate;

    private String endDate;

    private String status;

    private String note;
}
