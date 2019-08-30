package com.example.springbootjdbc.controller;

import com.example.springbootjdbc.model.UserModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final JdbcTemplate jdbcTemplate;

    public HelloController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/hello")
    public List<UserModel> hello(){

        // 查询所有用户
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(UserModel.class));

    }
}
