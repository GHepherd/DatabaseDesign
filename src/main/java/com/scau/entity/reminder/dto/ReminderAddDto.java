package com.scau.entity.reminder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ReminderAddDto {
    private String title;
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateTime;

    private String repeat;
    private String description;
    private String status;
}
