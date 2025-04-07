package com.scau.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 操作用户表Mapper
 */
@Mapper
public interface UserMapper {

    /**
     * 判断用户是否存在
     * @param user_id
     * @return 用户对应的记录数
     */
    @Select("select count(*) from databasedesigndb.users where user_id = #{user_id }")
    Integer ifExistUserId(Integer user_id);
}

/**
 * 1. UserMapper → 操作用户表
 * 2. VitalSignsMapper → 体征数据
 * 3. ExerciseMapper → 运动记录
 * 4. DietMapper → 饮食记录
 * 5. SleepMapper → 睡眠数据
 * 6. HealthGoalMapper → 健康目标
 * 7. ReminderMapper → 提醒功能
 */