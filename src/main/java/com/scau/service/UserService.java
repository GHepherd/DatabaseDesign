package com.scau.service;

import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.ChangePasswordDto;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserPersonalInfoDto;
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

    ResponseResult<UserPersonalInfoVo> getUserPersonalInfo();

    ResponseResult register(UserRegisterDto userRegisterDto);

    ResponseResult updateUserPersonalInfo(UserPersonalInfoDto userPersonalInfoDto);

    ResponseResult changePassword(ChangePasswordDto changePasswordDto);
}
