package com.example.web.FirstDemo.RestController;

import com.example.web.FirstDemo.Mapper.UserMapper;
import com.example.web.FirstDemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ApplicationContext applicationContext;

    @Autowired
    public UserController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        UserMapper userMapper = this.applicationContext.getBean(UserMapper.class);

        userMapper.insertUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        UserMapper userMapper = this.applicationContext.getBean(UserMapper.class);

        return userMapper.getAllUsers();
    }
}
