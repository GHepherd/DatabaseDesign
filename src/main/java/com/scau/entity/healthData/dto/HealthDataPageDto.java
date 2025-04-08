package com.scau.entity.healthData.dto;

import lombok.Data;

@Data
public class HealthDataPageDto
{
    private Integer page;
    private Integer limit;
    private String type;
    private String keyword;
}
