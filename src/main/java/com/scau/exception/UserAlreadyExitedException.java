package com.scau.exception;

import com.scau.constant.ResponseConstant;

public class UserAlreadyExitedException extends CustomException{
    public UserAlreadyExitedException() {super(ResponseConstant.USER_ALREADY_EXIST);}
    public UserAlreadyExitedException(String message) {super(message);}
}
