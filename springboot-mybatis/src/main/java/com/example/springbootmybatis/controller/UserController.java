package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.mapper.UserMapper;
import com.example.springbootmybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public void userList() {

        List<User> users = userMapper.findAll();

        System.out.println(users.get(0).toString());

    }


}
