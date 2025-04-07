package com.scau.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName health_reminders
 */
@TableName(value ="health_reminders")
@Data
public class HealthReminders implements Serializable {
    /**
     * 
     */
    @TableId(value = "reminder_id", type = IdType.AUTO)
    private Integer reminder_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "reminder_type")
    private Object reminder_type;

    /**
     * 
     */
    @TableField(value = "reminder_content")
    private String reminder_content;

    /**
     * 
     */
    @TableField(value = "trigger_time")
    private Date trigger_time;

    /**
     * 
     */
    @TableField(value = "is_completed")
    private Integer is_completed;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HealthReminders other = (HealthReminders) that;
        return (this.getReminder_id() == null ? other.getReminder_id() == null : this.getReminder_id().equals(other.getReminder_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getReminder_type() == null ? other.getReminder_type() == null : this.getReminder_type().equals(other.getReminder_type()))
            && (this.getReminder_content() == null ? other.getReminder_content() == null : this.getReminder_content().equals(other.getReminder_content()))
            && (this.getTrigger_time() == null ? other.getTrigger_time() == null : this.getTrigger_time().equals(other.getTrigger_time()))
            && (this.getIs_completed() == null ? other.getIs_completed() == null : this.getIs_completed().equals(other.getIs_completed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReminder_id() == null) ? 0 : getReminder_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getReminder_type() == null) ? 0 : getReminder_type().hashCode());
        result = prime * result + ((getReminder_content() == null) ? 0 : getReminder_content().hashCode());
        result = prime * result + ((getTrigger_time() == null) ? 0 : getTrigger_time().hashCode());
        result = prime * result + ((getIs_completed() == null) ? 0 : getIs_completed().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reminder_id=").append(reminder_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", reminder_type=").append(reminder_type);
        sb.append(", reminder_content=").append(reminder_content);
        sb.append(", trigger_time=").append(trigger_time);
        sb.append(", is_completed=").append(is_completed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}