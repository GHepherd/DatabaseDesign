package com.scau.entity.reminder.vo;

import lombok.Data;

import java.util.List;

@Data
public class ReminderGetVo {
    @Data
    public static class ReminderListData{
        private Integer total;
        private List<ReminderItem> list;
    }
    @Data
    public static class ReminderItem {
        private String id;
        private String title;
        private String type;
        private String dateTime;
        private String status;
        private String description;
    }
}
