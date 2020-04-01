package com.example.springboot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * 将配置文件中配置的每一个属性的值映射到这个组件中
 * @ConfigurationProperties:告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定；
 * prefix = "person"：配置文件中哪个下面的所有属性和进行映射
 *默认在全局配置文件中获取值
 * 只有这个组件是容器中的组件，才能使用@ConfigurationProperties提供的功能
 */

@Component
@PropertySource(value = {"classpath:person.properties"})//指定加载类路径下的person.propertise配置文件
@ConfigurationProperties(prefix = "person")
public class Person {

    /***
     * 除了@ConfigurationProperties(prefix = "person")注解以外，还有一种方法可以获取配置:@Value
     * <bean class="Person">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"><property/>
     * </>
     */
//    @Value("${person.lastName}")
    private String lastName;
    @Value("${person.age}")
    private Integer age;
//    @Value("false")
    private Boolean boos;
    private Date birth;

    private Map<String, Object> maps;
    private List<String> list;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boos=" + boos +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoos() {
        return boos;
    }

    public void setBoos(Boolean boos) {
        this.boos = boos;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
