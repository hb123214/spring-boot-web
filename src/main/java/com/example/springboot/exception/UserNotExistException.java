package com.example.springboot.exception;

public class UserNotExistException extends RuntimeException {
    //自定义异常
    public UserNotExistException() {
        super("用户不存在");
    }
}
