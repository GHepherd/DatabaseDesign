package com.scau.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scau.entity.healthGoal.dto.AddGoalDTO;
import com.scau.entity.healthGoal.dto.GoalPageDTO;
import com.scau.entity.healthGoal.pojo.HealthGoals;
import com.scau.entity.healthGoal.vo.HealthGoalVO;
import com.scau.entity.healthGoal.vo.PageResult;
import com.scau.exception.UserNotExitedException;
import com.scau.exception.UserNotLoginException;
import com.scau.mapper.HealthGoalMapper;
import com.scau.service.GoalTrackingService;
import com.scau.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public class GoalTrackingServiceImpl extends ServiceImpl<HealthGoalMapper,HealthGoals>
        implements GoalTrackingService{

    @Autowired
    HealthGoalMapper healthGoalMapper;

    @Override
    public PageResult<HealthGoalVO> getHealthGoalList(GoalPageDTO goalPageDTO) {
        Long userId= ThreadLocalUtil.getUserId();
        int pageNumber= goalPageDTO.getPage();
        int pageSize=goalPageDTO.getPageSize();
        if(userId==null){
            throw new UserNotLoginException();
        }
        String keyword= goalPageDTO.getKeyword();
        Page<HealthGoals> p=Page.of(pageNumber,pageSize);
        int total=0;
        List<HealthGoals> records;
        if(keyword.isEmpty()){
            QueryWrapper<HealthGoals> wrapper=new QueryWrapper<HealthGoals>()
                    .eq("user_id",userId);
            Page<HealthGoals> page=page(p,wrapper);
            records= page.getRecords();
            total= (int) page.getTotal();
        }else{
            QueryWrapper<HealthGoals> wrapper=new QueryWrapper<HealthGoals>()
                    .eq("user_id",userId)
                    .like("title",keyword);
            Page<HealthGoals> page=page(p,wrapper);
            records=page.getRecords();
            total= (int) page.getTotal();
        }
        List<HealthGoalVO> resultList=new ArrayList<>();
        for(HealthGoals goals:records){
            HealthGoalVO goalVO=new HealthGoalVO();
            goalVO.setId(String.valueOf(goals.getGoalId()));
            goalVO.setTitle(goals.getTitle());
            goalVO.setType(goals.getGoalType());
            goalVO.setTarget(goals.getTargetValue().longValue());
            goalVO.setCurrentProgress(goals.getCurrentProgress().intValue());
            goalVO.setStartDate(goals.getStartDate().toString());
            goalVO.setEndDate(goals.getEndDate().toString());
            goalVO.setStatus(goals.getStatus());
            goalVO.setNote(goals.getNote());
            resultList.add(goalVO);
        }
        return new PageResult<>(total,resultList);
    }

    @Override
    public String addHealthGoal(AddGoalDTO addGoalDTO) {
        Long userId= ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        HealthGoals healthGoals=new HealthGoals();
        healthGoals.setTitle(addGoalDTO.getName());
        healthGoals.setUserId(Integer.parseInt(String.valueOf(userId)));
        healthGoals.setGoalType(addGoalDTO.getType());
        healthGoals.setTargetValue(addGoalDTO.getTargetValue());
        healthGoals.setCurrentValue(addGoalDTO.getCurrentValue());
        healthGoals.setStartDate(addGoalDTO.getStartDate());
        healthGoals.setEndDate(addGoalDTO.getTargetDate());
        healthGoals.setStatus(addGoalDTO.getStatus());
        healthGoals.setCurrentProgress(addGoalDTO.getProgress());
        healthGoals.setNote(addGoalDTO.getDescription());
        healthGoalMapper.addHealGoal(healthGoals);
        int goalId= healthGoals.getGoalId();
        return String.valueOf(goalId);
    }

    @Override
    public void updateHealthGoal(Integer id, AddGoalDTO updateGoalDTO) {
        Long userId= ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        HealthGoals healthGoals=new HealthGoals();
        healthGoals.setGoalId(id);
        healthGoals.setTitle(updateGoalDTO.getName());
        healthGoals.setUserId(Integer.parseInt(String.valueOf(userId)));
        healthGoals.setGoalType(updateGoalDTO.getType());
        healthGoals.setTargetValue(updateGoalDTO.getTargetValue());
        healthGoals.setCurrentValue(updateGoalDTO.getCurrentValue());
        healthGoals.setStartDate(updateGoalDTO.getStartDate());
        healthGoals.setEndDate(updateGoalDTO.getTargetDate());
        healthGoals.setStatus(updateGoalDTO.getStatus());
        healthGoals.setCurrentProgress(updateGoalDTO.getProgress());
        healthGoals.setNote(updateGoalDTO.getDescription());
        healthGoalMapper.updateGoal(healthGoals);
    }

    @Override
    public void updateProgress(Integer id,Integer progress) {
        Long userId=ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        healthGoalMapper.updateProgress(userId,id,progress);
    }

    @Override
    public void completeTarget(Integer id) {
        Long userId=ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        String status="complete";
        healthGoalMapper.completeTarget(userId,id,status);
    }

    @Override
    public void deleteGoal(Integer id) {
        Long userId=ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        healthGoalMapper.deleteGoal(userId,id);
    }
}
