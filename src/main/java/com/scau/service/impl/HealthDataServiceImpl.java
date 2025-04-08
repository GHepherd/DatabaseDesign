package com.scau.service.impl;

import com.scau.entity.ResponseResult;
import com.scau.entity.healthData.dto.HealthDataPageDto;
import com.scau.entity.healthData.pojo.*;
import com.scau.entity.healthData.vo.HealthDataPageVo;
import com.scau.exception.ErrorHealthDataTypeException;
import com.scau.exception.UserNotLoginException;
import com.scau.mapper.DietRecordsMapper;
import com.scau.mapper.ExerciseRecordsMapper;
import com.scau.mapper.SleepRecordsMapper;
import com.scau.mapper.VitalSignsMapper;
import com.scau.service.HealthDataService;
import com.scau.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public class HealthDataServiceImpl implements HealthDataService {
    @Autowired
    VitalSignsMapper vitalSignsMapper;
    @Autowired
    ExerciseRecordsMapper exerciseRecordsMapper;
    @Autowired
    DietRecordsMapper dietRecordsMapper;
    @Autowired
    SleepRecordsMapper sleepRecordsMapper;


    /**
     * 获取健康数据列表
     * @param healthDataPageDto
     * @return
     */
    @Override
    public ResponseResult<HealthDataPageVo> getHealthDataList(HealthDataPageDto healthDataPageDto) {
        Long userId = ThreadLocalUtil.getUserId();
        if(userId == null) {
            throw new UserNotLoginException();
        }
        Integer page = healthDataPageDto.getPage();
        Integer limit = healthDataPageDto.getLimit();
        String type = healthDataPageDto.getType();
        String keyword = healthDataPageDto.getKeyword();
        HealthDataPageVo healthDataPageVo;
        if(HealthDataType.PHYSICAL.equals(type)) {
            List<VitalSigns> list= vitalSignsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo = new HealthDataPageVo<VitalSigns>() ;
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list);
        } else if (HealthDataType.EXERCISE.equals(type)) {
            List<ExerciseRecords> list= exerciseRecordsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo = new HealthDataPageVo<ExerciseRecords>();
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list);
        } else if (HealthDataType.DIET.equals(type)) {
            List<DietRecords> list= dietRecordsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo = new HealthDataPageVo<DietRecords>();
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list);
        } else if (HealthDataType.SLEEP.equals(type)) {
            List<SleepRecords> list= sleepRecordsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo = new HealthDataPageVo<SleepRecords>();
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list);
        }
        else{
            throw new ErrorHealthDataTypeException();
        }
        return ResponseResult.successResult(healthDataPageVo);
    }
}
