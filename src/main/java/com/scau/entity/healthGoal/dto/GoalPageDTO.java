package com.scau.entity.healthGoal.dto;

import lombok.Data;

@Data
public class GoalPageDTO {

    private Integer page;

    private Integer pageSize;

    private String keyword;


}
