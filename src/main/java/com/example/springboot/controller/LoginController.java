package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping
//    @RequestMapping(value = "login",method = RequestMethod.POST)
    @RequestMapping("/login")
    public String login(String username , String password, Map<String,Object>map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)){
            //登录成功
            if(username.equals("admin")&&password.equals("123456")){
                session.setAttribute("loginUser",username);
                return "redirect:main.html";
            }
        }
            //登录失败
            map.put("msg", "用户名或密码错误");
            return "login";

    }

}
