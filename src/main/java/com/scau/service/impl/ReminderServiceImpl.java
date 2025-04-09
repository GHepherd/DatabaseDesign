package com.scau.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scau.entity.ResponseResult;
import com.scau.entity.reminder.dto.ReminderAddDto;
import com.scau.entity.reminder.dto.ReminderGetDto;
import com.scau.entity.reminder.dto.ReminderUpdateDto;
import com.scau.entity.reminder.pojo.Reminder;
import com.scau.entity.reminder.vo.ReminderGetVo;
import com.scau.exception.UserNotLoginException;
import com.scau.mapper.ReminderMapper;
import com.scau.service.ReminderService;
import com.scau.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        Long userId = ThreadLocalUtil.getUserId();
        if (userId == null){
            throw new UserNotLoginException();
        }
        reminderMapper.deleteReminder(id);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult<ReminderGetVo.ReminderListData> reminderGet(ReminderGetDto reminderGetDto) {
        Long userId = ThreadLocalUtil.getUserId();
        if (userId == null){
            throw new UserNotLoginException();
        }
        ReminderGetVo.ReminderListData reminderListData = new ReminderGetVo.ReminderListData();
        Page<Reminder> page = new Page<>(reminderGetDto.getPage(),reminderGetDto.getLimit());
        QueryWrapper<Reminder> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("reminder_title",reminderGetDto.getKeyword())
                .like("reminder_type",reminderGetDto.getType())
                .like("status",reminderGetDto.getStatus());
        Page<Reminder> reminderPage = reminderMapper.selectPage(page,queryWrapper);
        List<ReminderGetVo.ReminderItem> list = reminderPage.getRecords().stream()
                .map(reminder -> {
                    ReminderGetVo.ReminderItem item = new ReminderGetVo.ReminderItem();
                    item.setId(String.valueOf(reminder.getReminderId()));
                    item.setTitle(reminder.getReminderTitle());
                    item.setType(reminder.getReminderType());
                    item.setStatus(reminder.getStatus());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String datetime = sdf.format(reminder.getDatetime());

                    item.setDateTime(datetime);
                    item.setDescription(reminder.getDescription());
                    return item;
                })
                .collect(Collectors.toList());
        reminderListData.setList(list);
        reminderListData.setTotal(list.size());
        return ResponseResult.successResult(reminderListData);
    }

}
