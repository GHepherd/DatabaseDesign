package com.scau.entity.healthGoal.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddGoalDTO {

    private String name;

    private String type;

    private String description;

    private BigDecimal currentValue;

    private BigDecimal targetValue;

    private Date startDate;

    private Date targetDate;

    private Integer progress;

    private String status;

}
