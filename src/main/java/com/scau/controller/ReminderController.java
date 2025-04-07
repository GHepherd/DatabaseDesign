package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.reminder.dto.ReminderAddDto;
import com.scau.entity.reminder.vo.ReminderAddVo;
import com.scau.service.ReminderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@RestController
@RequestMapping("/scau/health-reminders")
public class ReminderController {
    @Resource
    ReminderService reminderService;
    /**
     * 添加健康提醒
     * @return ResponseResult<UserPersonalInfoVo> 用户个人信息
     */
    @PutMapping("")
    public ResponseResult<ReminderAddVo> reminderAdd(@RequestBody ReminderAddDto reminderAddDto) {
        return reminderService.reminderAdd(reminderAddDto);
    }
}
