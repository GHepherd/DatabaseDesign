package com.scau.service.impl;

import cn.hutool.core.date.DateTime;
import com.scau.entity.ResponseResult;
import com.scau.entity.reminder.dto.ReminderAddDto;
import com.scau.entity.reminder.dto.ReminderGetDto;
import com.scau.entity.reminder.dto.ReminderUpdateDto;
import com.scau.entity.reminder.vo.ReminderGetVo;
import com.scau.exception.UserNotLoginException;
import com.scau.mapper.ReminderMapper;
import com.scau.service.ReminderService;
import com.scau.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public class ReminderServiceImpl implements ReminderService {
    @Resource
    private ReminderMapper reminderMapper;
    @Override
    public ResponseResult reminderAdd(ReminderAddDto reminderAddDto) {
        Long userId = ThreadLocalUtil.getUserId();
        if (userId == null){
            throw new UserNotLoginException();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(reminderAddDto.getDatetime(),formatter);
        reminderMapper.insertReminder(userId,reminderAddDto.getType(),reminderAddDto.getTitle(),
                reminderAddDto.getRepeat(),dateTime,reminderAddDto.getStatus(),
                reminderAddDto.getDescription());
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult reminderUpdate(Long id,ReminderUpdateDto reminderUpdateDto) {
        Long userId = ThreadLocalUtil.getUserId();
        if (userId == null){
            throw new UserNotLoginException();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(reminderUpdateDto.getDateTime(),formatter);
        reminderMapper.upDateReminder(id,reminderUpdateDto.getTitle(),
                dateTime,reminderUpdateDto.getRepeat(),
                reminderUpdateDto.getDescription());
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult reminderCompleteUpdate(Long id) {
        Long userId = ThreadLocalUtil.getUserId();
        if (userId == null){
            throw new UserNotLoginException();
        }
        reminderMapper.upDateReminderComplete(id);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult reminderDelete(Long id) {
        reminderMapper.deleteReminder(id);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult<ReminderGetVo.ReminderListData> reminderGet(ReminderGetDto reminderGetDto) {
        ReminderGetVo.ReminderListData reminderListData = new ReminderGetVo.ReminderListData();

        List<ReminderGetVo.ReminderItem> list = null;//待完成，后续需要编写mapper然后完成分页再将结果放入该list

        reminderListData.setList(list);
        reminderListData.setTotal(list.size());
        return ResponseResult.successResult(reminderListData);
    }

}
