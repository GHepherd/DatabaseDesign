package com.scau.service.impl;

import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserRegisterDto;
import com.scau.entity.user.vo.UserLoginVo;
import com.scau.entity.user.vo.UserPersonalInfoVo;
import com.scau.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResponseResult<UserLoginVo> userLogin(UserLoginDto userLoginDto) {
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setUserId("1");
        userLoginVo.setToken("123456");
        return ResponseResult.successResult(userLoginVo);
    }

    @Override
    public ResponseResult<UserPersonalInfoVo> getUserPersonalInfo(Long userId) {
        return null;
    }

    @Override
    public ResponseResult register(UserRegisterDto userRegisterDto) {
        return null;
    }
}
