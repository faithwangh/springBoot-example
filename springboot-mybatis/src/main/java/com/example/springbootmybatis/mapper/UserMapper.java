package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById();
}
