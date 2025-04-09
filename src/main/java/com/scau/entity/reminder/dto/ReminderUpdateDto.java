package com.scau.entity.reminder.dto;

import lombok.Data;

@Data
public class ReminderUpdateDto {
    private String title;
    private String dateTime;
    private String repeat;
    private String description;
}
