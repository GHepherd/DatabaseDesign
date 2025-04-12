package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.healthData.dto.HealthDataPageDto;
import com.scau.entity.healthData.vo.HealthDataPageVo;
import com.scau.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@RestController
@RequestMapping("/scau/health-data")
public class HealthDataController {

    @Autowired
    private HealthDataService healthDataService;

    /**
     *获取健康数据列表
     * @param healthDataPageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseResult<HealthDataPageVo> getHealthDataList(@RequestBody HealthDataPageDto healthDataPageDto){

        return healthDataService.getHealthDataList(healthDataPageDto);
    }

    /**
     * 添加健康数据
     * @param type
     * @param map
     * @return
     */
    @PostMapping("/{type}")
    public ResponseResult addHealthData(@PathVariable String type,@RequestBody Map<String,Object> map){
        return healthDataService.addHealthData(type,map);
    }

    /**
     * 更新健康数据
     * @param type
     * @param id
     * @param map
     * @return
     */
    @PostMapping("/{type}/{id}")
    public ResponseResult updateHealthData(@PathVariable String type,@PathVariable Long id,@RequestBody Map<String,Object> map){
        return healthDataService.updateHealthData(type,id,map);
    }

    /**
     * 删除健康数据
     * @param type
     * @param id
     * @return
     */
    @DeleteMapping("/{type}/{id}")
    public ResponseResult deleteHealthData(@PathVariable String type,@PathVariable Long id){
        return healthDataService.deleteHealthData(type,id);
    }
}
