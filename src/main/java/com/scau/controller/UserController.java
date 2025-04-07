package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserRegisterDto;
import com.scau.entity.user.vo.UserLoginVo;
import com.scau.entity.user.vo.UserPersonalInfoVo;
import com.scau.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@RestController
@RequestMapping("/scau/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param userRegisterDto 注册信息
     * @return 登录结果
     */
    @PostMapping("/register")
    public ResponseResult register(UserRegisterDto userRegisterDto) {
        return userService.register(userRegisterDto);
    }

    /**
     * 用户登录
     * @param userLoginDto 登录信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResponseResult<UserLoginVo> userLogin(@RequestBody UserLoginDto userLoginDto) {
        return userService.userLogin(userLoginDto);
    }

    /**
     * 获取用户个人信息
     * @param userId 用户id
     * @return ResponseResult<UserPersonalInfoVo> 用户个人信息
     */
    @GetMapping("/personal")
    public ResponseResult<UserPersonalInfoVo> getUserPersonalInfo(@RequestParam(value = "userId", required = false) Long userId){
        return userService.getUserPersonalInfo(userId);
    }


}


/**
 * 1. UserController
 *    - /scau/users → 用户基本信息接口
 *    - /scau/health-profile → 健康档案接口
 *
 * 2. DataController 
 *    - /scau/records/vital-signs → 体征数据
 *    - /scau/records/exercises → 运动记录
 *    - /scau/records/diets → 饮食记录
 *    - /scau/records/sleep → 睡眠数据
 *
 * 3. AnalysisController
 *    - /scau/analysis/trends → 趋势分析
 *    - /scau/analysis/risks → 风险评估
 *    - /scau/analysis/suggestions → 健康建议
 *
 * 4. GoalController
 *    - /scau/goals → 目标管理
 *    - /scau/goals/progress → 进度跟踪
 *
 * 5. ReminderController
 *    - /scau/reminders → 提醒管理
 *    - /scau/reminders/check → 提醒检查
 */
