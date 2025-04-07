package com.scau.exception;


import com.scau.constant.ResponseConstant;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
public class ErrorParamException extends CustomException{

    public ErrorParamException() {
        super(ResponseConstant.PARAM_INVALID);
    }

    public ErrorParamException(String msg) {
        super(msg);
    }
}