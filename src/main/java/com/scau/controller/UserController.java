package com.scau.controller;

import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.ChangePasswordDto;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserPersonalInfoDto;
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
    public ResponseResult register(@RequestBody UserRegisterDto userRegisterDto) {
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
     * @param
     * @return ResponseResult<UserPersonalInfoVo> 用户个人信息
     */
    @GetMapping("/info")
    public ResponseResult<UserPersonalInfoVo> getUserPersonalInfo(){
        return userService.getUserPersonalInfo();
    }

    /**
     * 更新用户信息
     * @param userPersonalInfoDto
     * @return
     */
    @PutMapping("/info")
    public ResponseResult updateUserPersonalInfo(@RequestBody UserPersonalInfoDto userPersonalInfoDto){
        return userService.updateUserPersonalInfo(userPersonalInfoDto);
    }

    /**
     * 修改密码
     * @param changePasswordDto
     * @return
     */
    @PutMapping("/password")
    public ResponseResult changePassword(@RequestBody ChangePasswordDto changePasswordDto){
        return userService.changePassword(changePasswordDto);
    }


}



