package com.scau.service;

import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserRegisterDto;
import com.scau.entity.user.vo.UserLoginVo;
import com.scau.entity.user.vo.UserPersonalInfoVo;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl（核心服务）
 *  - 用户注册/登录
 *  - 基础信息维护
 *  - 健康档案管理
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public interface UserService {
    ResponseResult<UserLoginVo> userLogin(UserLoginDto userLoginDto);

    ResponseResult<UserPersonalInfoVo> getUserPersonalInfo(Long userId);

    ResponseResult register(UserRegisterDto userRegisterDto);
}

/**
 * 1. UserServiceImpl（核心服务）
 *    - 用户注册/登录
 *    - 基础信息维护
 *    - 健康档案管理
 *
 * 2. DataRecordServiceImpl（聚合服务）
 *    - 统一处理体征/运动/饮食/睡眠记录
 *    - 批量数据导入导出
 *    - 跨类型数据查询
 *
 * 3. AnalysisService（复杂业务）
 *    - 趋势分析（体重/血压等）
 *    - 风险评估算法实现
 *    - 健康建议生成逻辑
 *
 * 4. GoalTrackingService（状态管理）
 *    - 目标进度计算
 *    - 目标达成判定
 *    - 目标提醒触发
 *
 * 5. ReminderService（定时任务）
 *    - 提醒规则管理
 *    - 定时任务调度
 *    - 提醒状态更新
 */