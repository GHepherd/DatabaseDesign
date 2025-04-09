package com.scau.mapper;

import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface ReminderMapper {
    @Insert("INSERT INTO health_reminders (reminder_id, user_id, reminder_type, reminder_title, reminder_repeat, datetime, status, description) " +
            "VALUES (0,#{user_id},#{reminder_type},#{reminder_title},#{reminder_repeat},#{datetime},#{status},#{description})")
    void insertReminder(Long user_id,
                        String reminder_type,
                        String reminder_title,
                        String reminder_repeat,
                        LocalDateTime datetime,
                        String status,
                        String description);
    @Update("UPDATE health_reminders " +
            "SET reminder_title = #{title},datetime = #{datetime},reminder_repeat = #{repeat},description = #{description} " +
            "WHERE reminder_id = #{reminder_id}")
    void upDateReminder(Long reminder_id,
                        String title,
                        LocalDateTime datetime,
                        String repeat,
                        String description);
    @Update("UPDATE health_reminders " +
            "SET status = 'completed' " +
            "WHERE reminder_id = #{reminder_id}")
    void upDateReminderComplete(Long id);
    @Delete("DELETE FROM health_reminders WHERE reminder_id = #{id}")
    void deleteReminder(Long id);
}
