package com.scau.entity.healthGoal.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddGoalDTO {

    private String name;

    private String type;

    private String description;


    private Date startDate;

    private Date targetDate;

    private Integer progress;

    private Integer status;

}
