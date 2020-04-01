package com.example.springboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 * */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user==null){
            //未登录
            request.setAttribute("msg","没有权限,请先登录");
            //请求转发到登录页面
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }
}
