package com.scau.entity.reminder.pojo;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@TableName(value ="health_reminders")
@Data
public class Reminder implements Serializable {
    /**
     * 提醒ID
     */
    @TableId(value = "reminder_id", type = IdType.AUTO)
    private int reminderId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private int userId;

    /**
     * 提醒类型
     */
    @TableField(value = "reminder_type")
    private String reminderType;

    /**
     * 提醒主题
     */
    @TableField(value = "reminder_title")
    private String reminderTitle;
    /**
     * 提醒频率
     */
    @TableField(value = "reminder_repeat")
    private String reminderRepeat;

    /**
     * 触发时间
     */
    @TableField(value = "datetime")
    private DateTime datetime;

    /**
     * 完成状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;
}

