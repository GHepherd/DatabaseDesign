package com.scau.service;

import com.scau.entity.ResponseResult;
import com.scau.entity.healthData.dto.HealthDataPageDto;
import com.scau.entity.healthData.vo.HealthDataPageVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * DataRecordServiceImpl（聚合服务）
 *    - 统一处理体征/运动/饮食/睡眠记录
 *    - 批量数据导入导出
 *    - 跨类型数据查询
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public interface HealthDataService {
    ResponseResult<HealthDataPageVo> getHealthDataList(HealthDataPageDto healthDataPageDto);

    ResponseResult addHealthData(String type,Map<String, Object> healthDataMap);

    ResponseResult updateHealthData(String type, Long id, Map<String, Object> map);

    ResponseResult deleteHealthData(String type, Long id);
}
