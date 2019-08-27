package com.example.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "cat" )
//@Validated
public class CatConfig {

//    @Email
    private String name;
    private Integer age;
    private Date birth;
    private Boolean my;
    private Map<String,Object> maps;
    private List<Integer> lists;
    private Child child;

    @Override
    public String toString() {
        return "CatConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", my=" + my +
                ", maps=" + maps +
                ", lists=" + lists +
                ", child=" + child +
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getMy() {
        return my;
    }

    public void setMy(Boolean my) {
        this.my = my;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Integer> getLists() {
        return lists;
    }

    public void setLists(List<Integer> lists) {
        this.lists = lists;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
