package com.scau.entity.user.pojo;

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
 * @TableName users
 */
@TableName(value ="users")
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer user_id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private Object gender;

    /**
     * 出生日期
     */
    @TableField(value = "birthdate")
    private Date birthdate;

    /**
     * 身高(cm)
     */
    @TableField(value = "height")
    private BigDecimal height;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date created_at;

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
        User other = (User) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthdate() == null ? other.getBirthdate() == null : this.getBirthdate().equals(other.getBirthdate()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthdate() == null) ? 0 : getBirthdate().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_id=").append(user_id);
        sb.append(", username=").append(username);
        sb.append(", gender=").append(gender);
        sb.append(", birthdate=").append(birthdate);
        sb.append(", height=").append(height);
        sb.append(", created_at=").append(created_at);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}