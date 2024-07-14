package com.example.web.FirstDemo.Mapper;

import com.example.web.FirstDemo.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO users (name, age) VALUES (#{name}, #{age})")
    void insertUser(User user);

    @Select("SELECT name, age FROM users")
    List<User> getAllUsers();
}