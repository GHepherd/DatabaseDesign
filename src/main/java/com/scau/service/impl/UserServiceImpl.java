package com.scau.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.digest.MD5;
import com.scau.constant.TokenMap;
import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.ChangePasswordDto;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserPersonalInfoDto;
import com.scau.entity.user.dto.UserRegisterDto;
import com.scau.entity.user.pojo.User;
import com.scau.entity.user.vo.UserLoginVo;
import com.scau.entity.user.vo.UserPersonalInfoVo;
import com.scau.exception.PasswordErrorException;
import com.scau.exception.UserAlreadyExitedException;
import com.scau.exception.UserNotExitedException;
import com.scau.exception.UserNotLoginException;
import com.scau.mapper.UserMapper;
import com.scau.service.UserService;
import com.scau.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * 用户登录
     * @param userLoginDto
     * @return
     */
    @Override
    public ResponseResult<UserLoginVo> userLogin(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        User user=userMapper.selectUserByUsername(username);
        if(user==null){
            throw new UserNotExitedException();
        }
        if(!user.getPassword().equals(userLoginDto.getPassword())) {
            throw new UserNotExitedException();
        }
        UserLoginVo userLoginVo = new UserLoginVo();
        String token = MD5.create().digestHex(username);
        TokenMap.put(token,user.getUserId());
        System.out.println(TokenMap.get(token));
        userLoginVo.setToken(token);
        return ResponseResult.successResult(userLoginVo);
    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public ResponseResult<UserPersonalInfoVo> getUserPersonalInfo() {
        Long userId = ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        User user=userMapper.selectUserById(userId);
        UserPersonalInfoVo userPersonalInfoVo = new UserPersonalInfoVo();
        userPersonalInfoVo.setUsername(user.getUsername());
        userPersonalInfoVo.setEmail(user.getEmail());
        return ResponseResult.successResult(userPersonalInfoVo);
    }

    /**
     * 用户注册
     * @param userRegisterDto
     * @return
     */
    @Override
    public ResponseResult register(UserRegisterDto userRegisterDto) {
        String username = userRegisterDto.getUsername();
        User user = userMapper.selectUserByUsername(username);
        if(user!=null){
            throw new UserAlreadyExitedException();
        }
        userMapper.insertUser(username,userRegisterDto.getPassword(),userRegisterDto.getEmail(), DateTime.now());
        return ResponseResult.successResult();
    }

    /**
     * 更新用户信息
     * @param userPersonalInfoDto
     * @return
     */
    @Override
    public ResponseResult updateUserPersonalInfo(UserPersonalInfoDto userPersonalInfoDto) {
        Long userId = ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        userMapper.updateUserById(userId,userPersonalInfoDto.getUsername(),userPersonalInfoDto.getEmail());
        return ResponseResult.successResult();
    }

    /**
     * 修改密码
     * @param changePasswordDto
     * @return
     */
    @Override
    public ResponseResult changePassword(ChangePasswordDto changePasswordDto) {
        Long userId = ThreadLocalUtil.getUserId();
        if(userId==null){
            throw new UserNotLoginException();
        }
        User user = userMapper.selectUserById(userId);
        if(!user.getPassword().equals(changePasswordDto.getOldPassword())){
            throw new PasswordErrorException();
        }
        userMapper.updatePasswordById(userId,changePasswordDto.getNewPassword());
        return ResponseResult.successResult();
    }
}
