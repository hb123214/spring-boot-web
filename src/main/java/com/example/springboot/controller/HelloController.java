package com.example.springboot.controller;

import com.example.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

//新建分支
//合并分支
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(String userName){
        if(!"aaa".equals(userName)){
            //抛出自定义异常
            throw new UserNotExistException();
        }
        return "hello wold";
    }

    @RequestMapping("success")
    public String success(Map<String,Object>map){
        map.put("msg", "<h1>666</h1>");
        map.put("users",Arrays.asList("张三", "李四", "王五"));
        return "success";
    }
}
