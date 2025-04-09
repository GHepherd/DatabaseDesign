package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.healthGoal.dto.AddGoalDTO;
import com.scau.entity.healthGoal.dto.GoalPageDTO;
import com.scau.entity.healthGoal.vo.HealthGoalVO;
import com.scau.entity.healthGoal.vo.PageResult;
import com.scau.service.GoalTrackingService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@RestController
@RequestMapping("/scau/health_goal")
public class HealthGoalController {

    @Autowired
    private GoalTrackingService goalTrackingService;


    /*
    * 获取健康目标列表
    * */
    @GetMapping("/list")
    public ResponseResult<PageResult<HealthGoalVO>> getHealthGoalList(GoalPageDTO goalPageDTO){
        PageResult<HealthGoalVO> result = goalTrackingService.getHealthGoalList(goalPageDTO);
        return ResponseResult.successResult(result);
    }


    /*
    *
    * 添加健康目标
    * */
    @PostMapping
    public ResponseResult<String> addHealthGoal(@RequestBody AddGoalDTO addGoalDTO){
        String id = goalTrackingService.addHealthGoal(addGoalDTO);
        return ResponseResult.successResult(id);
    }

    /*
    * 修改健康目标
    * */
    @PutMapping("/{id}")
    public ResponseResult updateHealthGoal(@PathVariable Integer id, @RequestBody AddGoalDTO updateGoalDTO){
        goalTrackingService.updateHealthGoal(id,updateGoalDTO);
        return ResponseResult.successResult();
    }

    /*
    * 更新目标进度
    * */

    @PutMapping("/{id}/progress")
    public ResponseResult updateProgress(@PathVariable Integer id,Integer progress){
        goalTrackingService.updateProgress(id,progress);
        return ResponseResult.successResult();
    }



    /*
    * 完成对应目标
    * */
    @PutMapping("/{id}/complete")
    public ResponseResult completeTarget(@PathVariable Integer id){
        goalTrackingService.completeTarget(id);
        return ResponseResult.successResult();
    }


    /*
    * 删除对应健康目标
    * */

    @DeleteMapping("/{id}")
    public ResponseResult deleteGoal(@PathVariable Integer id){
        goalTrackingService.deleteGoal(id);
        return ResponseResult.successResult();
    }

}
