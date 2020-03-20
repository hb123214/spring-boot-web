package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello wold";
    }

    @RequestMapping("success")
    public String success(Map<String,Object>map){
        map.put("msg", "<h1>666</h1>");
        map.put("users",Arrays.asList("张三", "李四", "王五"));
        return "success";
    }
}
