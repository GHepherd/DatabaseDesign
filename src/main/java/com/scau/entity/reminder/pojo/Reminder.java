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
     * 提醒内容
     */
    @TableField(value = "reminder_content")
    private String reminderContent;

    /**
     * 触发时间
     */
    @TableField(value = "trigger_time")
    private DateTime triggerTime;

    /**
     * 是否完成
     */
    @TableField(value = "is_completed")
    private boolean isCompleted;
}

