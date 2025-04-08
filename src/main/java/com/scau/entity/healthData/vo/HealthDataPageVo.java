package com.scau.entity.healthData.vo;

import lombok.Data;

import java.util.List;

@Data
public class HealthDataPageVo<T>
{
    private Integer total;
    private List<T> list;
}
