package com.scau.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.scau.constant.TokenMap;
import com.scau.entity.ResponseResult;
import com.scau.entity.user.dto.UserLoginDto;
import com.scau.entity.user.dto.UserRegisterDto;
import com.scau.entity.user.pojo.User;
import com.scau.entity.user.vo.UserLoginVo;
import com.scau.entity.user.vo.UserPersonalInfoVo;
import com.scau.exception.UserNotExitedException;
import com.scau.mapper.UserMapper;
import com.scau.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
        userLoginVo.setToken(token);
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
