package com.example.springbootconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:my.properties")
@ConfigurationProperties(prefix = "my")
public class MyConfig {

//    @Value("${my.name}")
    private String name;
//    @Value("${my.age}")
    private Integer age;

    @Override
    public String toString() {
        return "MyConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
