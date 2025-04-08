package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.healthData.dto.HealthDataPageDto;
import com.scau.entity.healthData.vo.HealthDataPageVo;
import com.scau.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@RestController
@RequestMapping("/scau/health_data")
public class HealthDataController {

    @Autowired
    private HealthDataService healthDataService;

    @GetMapping("/list")
    public ResponseResult<HealthDataPageVo> getHealthDataList(@RequestBody HealthDataPageDto healthDataPageDto){
        return healthDataService.getHealthDataList(healthDataPageDto);
    }
}
