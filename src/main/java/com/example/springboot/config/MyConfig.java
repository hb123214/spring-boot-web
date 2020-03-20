package com.example.springboot.config;




import com.example.springboot.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//可以扩展springmvc的功能
@Configuration
public class MyConfig implements WebMvcConfigurer {

    //添加视图映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //浏览器发送"/","/index.html"请求,来到login页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("index.html").setViewName("login");
        registry.addViewController("main.html").setViewName("dashboard");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 添加要拦截的地址,
        //excludePathPatterns 判处不需要拦截的地址,其中包括:
        // "index.html" 项目访问主页
        // "/" 项目访问主页
        // "/login" 登录请求的控制器
        // "/index_files/**" 静态资源文件
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/login","/index_files/**");
    }
}
