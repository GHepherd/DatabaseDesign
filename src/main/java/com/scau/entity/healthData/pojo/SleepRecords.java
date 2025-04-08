package com.scau.entity.healthData.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sleep_records
 */
@TableName(value ="sleep_records")
@Data
public class SleepRecords {
    /**
     * 
     */
    @TableId(value = "sleep_id", type = IdType.AUTO)
    private Integer sleep_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 
     */
    @TableField(value = "sleep_start")
    private Date sleep_start;

    /**
     * 
     */
    @TableField(value = "sleep_end")
    private Date sleep_end;

    /**
     * 深睡时长(分钟)
     */
    @TableField(value = "deep_sleep_minutes")
    private Integer deep_sleep_minutes;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date created_at;

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
        SleepRecords other = (SleepRecords) that;
        return (this.getSleep_id() == null ? other.getSleep_id() == null : this.getSleep_id().equals(other.getSleep_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getSleep_start() == null ? other.getSleep_start() == null : this.getSleep_start().equals(other.getSleep_start()))
            && (this.getSleep_end() == null ? other.getSleep_end() == null : this.getSleep_end().equals(other.getSleep_end()))
            && (this.getDeep_sleep_minutes() == null ? other.getDeep_sleep_minutes() == null : this.getDeep_sleep_minutes().equals(other.getDeep_sleep_minutes()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSleep_id() == null) ? 0 : getSleep_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getSleep_start() == null) ? 0 : getSleep_start().hashCode());
        result = prime * result + ((getSleep_end() == null) ? 0 : getSleep_end().hashCode());
        result = prime * result + ((getDeep_sleep_minutes() == null) ? 0 : getDeep_sleep_minutes().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sleep_id=").append(sleep_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", sleep_start=").append(sleep_start);
        sb.append(", sleep_end=").append(sleep_end);
        sb.append(", deep_sleep_minutes=").append(deep_sleep_minutes);
        sb.append(", note=").append(note);
        sb.append(", created_at=").append(created_at);
        sb.append("]");
        return sb.toString();
    }
}