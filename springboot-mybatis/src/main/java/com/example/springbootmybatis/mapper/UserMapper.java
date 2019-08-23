package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "name", column = "unique_name")
    })
    List<User> findAll();


    @Select("select * from user where id = #{id}")
    Optional<User> findById(Long id);

    @Insert("INSERT INTO user(unique_name,password,gender,is_active) VALUES(#{name},#{password}, #{gender}, #{isActive})")
    void insert(User user);

//    @Update("")
//    User update();

    @SelectProvider()
    List<User> findAllBy();

}
