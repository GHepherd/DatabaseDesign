package com.scau.service;

import com.scau.entity.ResponseResult;
import com.scau.entity.reminder.dto.ReminderAddDto;
import com.scau.entity.reminder.vo.ReminderAddVo;
import org.springframework.stereotype.Service;

/**
 *  ReminderService（定时任务）
 *    - 提醒规则管理
 *    - 定时任务调度
 *    - 提醒状态更新
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public interface ReminderService {
    ResponseResult<ReminderAddVo> reminderAdd(ReminderAddDto reminderAddDto);
}
