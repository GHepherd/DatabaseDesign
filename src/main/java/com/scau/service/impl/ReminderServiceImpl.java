package com.scau.service.impl;

import com.scau.entity.ResponseResult;
import com.scau.entity.reminder.dto.ReminderAddDto;
import com.scau.entity.reminder.vo.ReminderAddVo;
import com.scau.service.ReminderService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public class ReminderServiceImpl implements ReminderService {
    @Override
    public ResponseResult<ReminderAddVo> reminderAdd(ReminderAddDto reminderAddDto) {
        ReminderAddVo reminderAddVo = new ReminderAddVo();
        return ResponseResult.successResult(reminderAddVo);
    }
}
