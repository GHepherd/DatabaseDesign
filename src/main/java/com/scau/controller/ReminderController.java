package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.reminder.dto.ReminderAddDto;
import com.scau.entity.reminder.dto.ReminderGetDto;
import com.scau.entity.reminder.dto.ReminderUpdateDto;
import com.scau.entity.reminder.vo.ReminderGetVo;
import com.scau.service.ReminderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@RestController
@RequestMapping("/scau/health-reminder")
public class ReminderController {
    @Resource
    ReminderService reminderService;
    /**
     * 获取健康提醒列表
     */
    @GetMapping("/list")
    public ResponseResult<ReminderGetVo.ReminderListData> reminderGet(ReminderGetDto reminderGetDto){
        return reminderService.reminderGet(reminderGetDto);
    }
    /**
     * 添加健康提醒
     */
    @PostMapping("")
    public ResponseResult reminderAdd(@RequestBody ReminderAddDto reminderAddDto) {
        return reminderService.reminderAdd(reminderAddDto);
    }
    /**
     * 更新健康提醒
     */
    @PutMapping("/{id}")
    public ResponseResult reminderUpdate(@PathVariable Long id,@RequestBody ReminderUpdateDto reminderUpdateDto){
        return reminderService.reminderUpdate(id,reminderUpdateDto);
    }
    /**
     * 标记完成健康提醒
     */
    @PutMapping("/{id}/complete")
    public ResponseResult reminderCompleteUpdate(@PathVariable Long id){
        return reminderService.reminderCompleteUpdate(id);
    }
    /**
     * 删除健康提醒
     */
    @DeleteMapping("/{id}")
    public ResponseResult reminderDelete(@PathVariable Long id){
        return reminderService.reminderDelete(id);
    }
}
