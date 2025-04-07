package com.scau.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName health_goals
 */
@TableName(value ="health_goals")
@Data
public class HealthGoals implements Serializable {
    /**
     * 
     */
    @TableId(value = "goal_id", type = IdType.AUTO)
    private Integer goal_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "goal_type")
    private Object goal_type;

    /**
     * 目标数值
     */
    @TableField(value = "target_value")
    private BigDecimal target_value;

    /**
     * 
     */
    @TableField(value = "start_date")
    private Date start_date;

    /**
     * 
     */
    @TableField(value = "end_date")
    private Date end_date;

    /**
     * 
     */
    @TableField(value = "current_progress")
    private BigDecimal current_progress;

    /**
     * 
     */
    @TableField(value = "status")
    private Object status;

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
        HealthGoals other = (HealthGoals) that;
        return (this.getGoal_id() == null ? other.getGoal_id() == null : this.getGoal_id().equals(other.getGoal_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getGoal_type() == null ? other.getGoal_type() == null : this.getGoal_type().equals(other.getGoal_type()))
            && (this.getTarget_value() == null ? other.getTarget_value() == null : this.getTarget_value().equals(other.getTarget_value()))
            && (this.getStart_date() == null ? other.getStart_date() == null : this.getStart_date().equals(other.getStart_date()))
            && (this.getEnd_date() == null ? other.getEnd_date() == null : this.getEnd_date().equals(other.getEnd_date()))
            && (this.getCurrent_progress() == null ? other.getCurrent_progress() == null : this.getCurrent_progress().equals(other.getCurrent_progress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoal_id() == null) ? 0 : getGoal_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getGoal_type() == null) ? 0 : getGoal_type().hashCode());
        result = prime * result + ((getTarget_value() == null) ? 0 : getTarget_value().hashCode());
        result = prime * result + ((getStart_date() == null) ? 0 : getStart_date().hashCode());
        result = prime * result + ((getEnd_date() == null) ? 0 : getEnd_date().hashCode());
        result = prime * result + ((getCurrent_progress() == null) ? 0 : getCurrent_progress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goal_id=").append(goal_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", goal_type=").append(goal_type);
        sb.append(", target_value=").append(target_value);
        sb.append(", start_date=").append(start_date);
        sb.append(", end_date=").append(end_date);
        sb.append(", current_progress=").append(current_progress);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}