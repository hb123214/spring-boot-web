package com.example.springboot.config;




import com.example.springboot.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 *@Configuration:指明，这是一个配置类,替代spring配置文件
 *
 *在配置文件中用<bean><bean/>标签添加组件
 */
//可以扩展springmvc的功能
@Configuration
public class MyConfig implements WebMvcConfigurer {

    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HelloWorldService helloWorldService(){
        return new HelloWorldService();
    }

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
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/login","/index_files/**");
    }
}
