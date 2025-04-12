package com.scau.entity.reminder.vo;

import com.scau.entity.reminder.pojo.Reminder;
import lombok.Data;

import java.util.List;

@Data
public class ReminderGetVo extends Reminder {
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
