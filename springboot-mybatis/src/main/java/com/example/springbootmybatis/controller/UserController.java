package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.mapper.UserMapper;
import com.example.springbootmybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<User> userList() {

        List<User> users = userMapper.findAll();

        return users;
    }

    @GetMapping("/users/{id}")
    public User detail(@PathVariable Long id) {

        Optional<User> optionalUser = userMapper.findById(id);

        return optionalUser.isPresent() ? optionalUser.get() : null;

    }

    @GetMapping("/insert/user")
    public void insert() {
        User user = new User();
        user.setName("168123437447");
        user.setPassword("12344556");
        user.setGender("male");
        user.setIsActive(1);

        userMapper.insert(user);
    }


}
