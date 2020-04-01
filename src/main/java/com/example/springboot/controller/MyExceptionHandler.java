package com.example.springboot.controller;

import com.example.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    //自定义异常处理
    //浏览器和客户端都是同样的json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code", "user.notExist");
//        map.put("massage", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest req){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "user.notExist");
        map.put("massage", e.getMessage());
        /*
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        传入自定义状态码
        */
        req.setAttribute("javax.servlet.error.status_code",500);
        //将数据放入请求域中
        req.setAttribute("etx", map);
        //转发到/error
        return "forward:/error";
    }

}
