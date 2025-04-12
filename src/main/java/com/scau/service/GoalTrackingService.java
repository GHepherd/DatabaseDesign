package com.scau.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scau.entity.healthGoal.dto.AddGoalDTO;
import com.scau.entity.healthGoal.dto.GoalPageDTO;
import com.scau.entity.healthGoal.pojo.HealthGoals;
import com.scau.entity.healthGoal.vo.HealthGoalVO;
import com.scau.entity.healthGoal.vo.PageResult;
import org.springframework.stereotype.Service;

/**
 * GoalTrackingService（状态管理）
 *    - 目标进度计算
 *    - 目标达成判定
 *    - 目标提醒触发
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public interface GoalTrackingService extends IService<HealthGoals> {

        PageResult<HealthGoalVO> getHealthGoalList(GoalPageDTO goalPageDTO);

        void addHealthGoal(AddGoalDTO addGoalDTO);

        void updateHealthGoal(Integer id, AddGoalDTO updateGoalDTO);

        void updateProgress(Integer id, Integer progress);

        void completeTarget(Integer id);

        void deleteGoal(Integer id);
}
