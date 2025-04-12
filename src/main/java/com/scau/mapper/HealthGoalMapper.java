package com.scau.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.entity.healthGoal.pojo.HealthGoals;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface HealthGoalMapper extends BaseMapper<HealthGoals> {

    void addHealGoal(HealthGoals healthGoals);

    void updateGoal(HealthGoals healthGoals);

    @Update("update health_goals set current_progress=#{progress} " +
            "where user_id=#{userId} and goal_id=#{id}")
    void updateProgress(Long userId, Integer id, Integer progress);


    @Update("update health_goals set status=#{status} " +
            "where user_id=#{userId} and goal_id=#{id}")
    void completeTarget(Long userId, Integer id, String status);


    @Delete("delete from health_goals where goal_id=#{id} and user_id=#{userId}")
    void deleteGoal(Long userId, Integer id);
}
