package com.scau.exception;

public class ErrorHealthDataTypeException extends CustomException{
    public ErrorHealthDataTypeException() {super("错误的健康数据类型");}
    public ErrorHealthDataTypeException(String message) {super(message);}
}
