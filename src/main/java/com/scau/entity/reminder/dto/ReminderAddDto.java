package com.scau.entity.reminder.dto;

import lombok.Data;

@Data
public class ReminderAddDto {
    private String title;
    private String type;
    private String datetime;
    private String repeat;
    private String description;
    private String status;
}
