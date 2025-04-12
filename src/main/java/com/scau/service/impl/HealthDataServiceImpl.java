package com.scau.service.impl;

import com.scau.entity.ResponseResult;
import com.scau.entity.healthData.dto.HealthDataPageDto;
import com.scau.entity.healthData.pojo.*;
import com.scau.entity.healthData.vo.*;
import com.scau.exception.ErrorHealthDataTypeException;
import com.scau.exception.UserNotLoginException;
import com.scau.mapper.DietRecordsMapper;
import com.scau.mapper.ExerciseRecordsMapper;
import com.scau.mapper.SleepRecordsMapper;
import com.scau.mapper.VitalSignsMapper;
import com.scau.service.HealthDataService;
import com.scau.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        HealthDataPageVo healthDataPageVo=new HealthDataPageVo();
        if(HealthDataType.PHYSICAL.equals(type)) {
            List<VitalSigns> list= vitalSignsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list.stream().map(VitalSignsVo::new).collect(Collectors.toList()));
        } else if (HealthDataType.EXERCISE.equals(type)) {
            List<ExerciseRecords> list= exerciseRecordsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list.stream().map(ExerciseRecordsVo::new).collect(Collectors.toList()));
        } else if (HealthDataType.DIET.equals(type)) {
            List<DietRecords> list= dietRecordsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list.stream().map(DietRecordsVo::new).collect(Collectors.toList()));
        } else if (HealthDataType.SLEEP.equals(type)) {
            List<SleepRecords> list= sleepRecordsMapper.selectList(userId,(page-1)*limit,limit,keyword);
            healthDataPageVo.setTotal(list.size());
            healthDataPageVo.setList(list.stream().map(SleepRecordsVo::new).collect(Collectors.toList()));
        }
        else{
            throw new ErrorHealthDataTypeException();
        }
        return ResponseResult.successResult(healthDataPageVo);
    }
    /**
     * 添加健康数据
     * @param type
     * @param healthDataMap
     * @return
     */
    @Override
    public ResponseResult addHealthData(String type,Map<String, Object> healthDataMap) {
        Long userId = ThreadLocalUtil.getUserId();

        if(userId == null) {
            throw new UserNotLoginException();
        }
        try {
            for (Map.Entry<String, Object> entry : healthDataMap.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    // 处理数值类型的转换
                    if (isNumericField(entry.getKey())) {
                        try {
                            healthDataMap.put(entry.getKey(), Double.valueOf(String.valueOf(value)));
                        } catch (NumberFormatException e) {
                            healthDataMap.put(entry.getKey(), 0.0);
                        }
                    }
                }
            }
            if(HealthDataType.PHYSICAL.equals(type)) {
                String note = (String) healthDataMap.get("note");
                Double height = (Double)(healthDataMap.get("height"));
                Double weight = (Double) healthDataMap.get("weight");
                Double bloodPressure = (Double) healthDataMap.get("bloodPressure");
                Double bloodSugar = (Double) healthDataMap.get("bloodSugar");
                Double bloodLipids = (Double) healthDataMap.get("bloodLipids");
                vitalSignsMapper.insert(userId,height,weight,bloodPressure,bloodSugar,bloodLipids,note);
            }
            else if(HealthDataType.EXERCISE.equals(type)) {
                String note = (String) healthDataMap.get("note");
                String exerciseType = (String) healthDataMap.get("exerciseType");
                Double duration = (Double) healthDataMap.get("duration");
                Double distance = (Double) healthDataMap.get("distance");
                Double calories = (Double) healthDataMap.get("calories");
                Double heartRate = (Double) healthDataMap.get("heartRate");
                exerciseRecordsMapper.insert(userId,exerciseType,duration,distance,calories,heartRate,note);
            }
            else if(HealthDataType.DIET.equals(type)) {
                String note = (String) healthDataMap.get("note");
                String mealTime = (String) healthDataMap.get("mealTime");
                String foodName = (String) healthDataMap.get("foodName");
                Double amount = Double.parseDouble(String.valueOf(healthDataMap.get("amount")));
                Double protein = Double.parseDouble(String.valueOf(healthDataMap.get("protein")));
                Double carbs = Double.parseDouble(String.valueOf(healthDataMap.get("carbs")));
                Double fat = Double.parseDouble(String.valueOf(healthDataMap.get("fat")));
                dietRecordsMapper.insert(userId,mealTime,foodName,amount,protein,carbs,fat,note);
            }
            else if(HealthDataType.SLEEP.equals(type)) {
                String note = (String) healthDataMap.get("note");
                String startTime = (String) healthDataMap.get("startTime");
                String endTime = (String) healthDataMap.get("endTime");
                Double deepSleep = (Double) healthDataMap.get("deepSleep");
                sleepRecordsMapper.insert(userId,startTime,endTime,deepSleep,note);
            }
        } catch (Exception e) {
            System.out.println("/n/n/n/n/n/n");
            System.out.println(e);
            System.out.println("/n/n/n/n/n/n");
            throw new ErrorHealthDataTypeException();
        }
        return ResponseResult.successResult();
    }

    /**
     * 更新健康数据
     * @param type
     * @param id
     * @param healthDataMap
     * @return
     */
    @Override
    public ResponseResult updateHealthData(String type, Long id, Map<String, Object> healthDataMap) {
        Long userId = ThreadLocalUtil.getUserId();
        if(userId == null) {
            throw new UserNotLoginException();
        }
        try {
            for (Map.Entry<String, Object> entry : healthDataMap.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    // 处理数值类型的转换
                    if (isNumericField(entry.getKey())) {
                        try {
                            healthDataMap.put(entry.getKey(), Double.valueOf(String.valueOf(value)));
                        } catch (NumberFormatException e) {
                            healthDataMap.put(entry.getKey(), 0.0);
                        }
                    }
                }
            }
            if(HealthDataType.PHYSICAL.equals(type)) {
                String note = (String) healthDataMap.get("note");
                Double height = Double.valueOf(String.valueOf(healthDataMap.get("height")));
                Double weight = Double.valueOf(String.valueOf(healthDataMap.get("weight")));
                Double bloodPressure = (Double) healthDataMap.get("bloodPressure");
                Double bloodSugar = (Double) healthDataMap.get("bloodSugar");
                Double bloodLipids = (Double) healthDataMap.get("bloodLipids");
                vitalSignsMapper.updateById(id,userId,height,weight,bloodPressure,bloodSugar,bloodLipids,note);
            }
            else if(HealthDataType.EXERCISE.equals(type)) {
                String note = (String) healthDataMap.get("note");
                String exerciseType = (String) healthDataMap.get("exerciseType");
                Double duration = (Double) healthDataMap.get("duration");
                Double distance = (Double) healthDataMap.get("distance");
                Double calories = (Double) healthDataMap.get("calories");
                Double heartRate = (Double) healthDataMap.get("heartRate");
                exerciseRecordsMapper.updateById(id,userId,exerciseType,duration,distance,calories,heartRate,note);
            }
            else if(HealthDataType.DIET.equals(type)) {
                String note = (String) healthDataMap.get("note");
                String mealTime = (String) healthDataMap.get("mealTime");
                String foodName = (String) healthDataMap.get("foodName");
                Double amount = Double.parseDouble(String.valueOf(healthDataMap.get("amount")));
                Double protein = Double.parseDouble(String.valueOf(healthDataMap.get("protein")));
                Double carbs = Double.parseDouble(String.valueOf(healthDataMap.get("carbs")));
                Double fat = Double.parseDouble(String.valueOf(healthDataMap.get("fat")));
                dietRecordsMapper.updateById(id,userId,mealTime,foodName,amount,protein,carbs,fat,note);
            }
            else if(HealthDataType.SLEEP.equals(type)) {
                String note = (String) healthDataMap.get("note");
                String startTime = (String) healthDataMap.get("startTime");
                String endTime = (String) healthDataMap.get("endTime");
                Double deepSleep = (Double) healthDataMap.get("deepSleep");
                sleepRecordsMapper.updateById(id,userId,startTime,endTime,deepSleep,note);
            }
        } catch (Exception e) {
            throw new ErrorHealthDataTypeException();
        }
        return ResponseResult.successResult();
    }

    /**
     * 删除健康数据
     * @param type
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteHealthData(String type, Long id) {
        Long userId = ThreadLocalUtil.getUserId();
        if(userId == null) {
            throw new UserNotLoginException();
        }
        if(HealthDataType.PHYSICAL.equals(type)) {
            vitalSignsMapper.deleteById(id,userId);
        }
        else if(HealthDataType.EXERCISE.equals(type)) {
            exerciseRecordsMapper.deleteById(id,userId);
        }
        else if(HealthDataType.DIET.equals(type)) {
            dietRecordsMapper.deleteById(id,userId);
        }
        else if(HealthDataType.SLEEP.equals(type)) {
            sleepRecordsMapper.deleteById(id,userId);
        }
        else {
            throw new ErrorHealthDataTypeException();
        }
        return ResponseResult.successResult();
    }

    /**
     * 判断字段是否为数值类型字段
     * @param fieldName 字段名
     * @return 是否为数值类型字段
     */
    private boolean isNumericField(String fieldName) {
        return fieldName.equals("height") || fieldName.equals("weight") ||
               fieldName.equals("bloodPressure") || fieldName.equals("bloodSugar") ||
               fieldName.equals("bloodLipids") || fieldName.equals("duration") ||
               fieldName.equals("distance") || fieldName.equals("calories") ||
               fieldName.equals("heartRate") || fieldName.equals("amount") ||
               fieldName.equals("protein") || fieldName.equals("carbs") ||
               fieldName.equals("fat") || fieldName.equals("deepSleep");
    }
}
