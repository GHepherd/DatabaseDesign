package com.scau.entity.reminder.dto;

import lombok.Data;

@Data
public class ReminderGetDto {
    private Integer page;
    private Integer limit;
    private String keyword;
    private String type;
    private String status;
}
