package com.scau.entity.healthGoal.vo;

import lombok.Data;

@Data
public class HealthGoalVO {

    private Integer id;

    private String name;

    private String type;

    private String description;

    private Integer progress;

    private String startDate;

    private String targetDate;

    private Integer status;


}
