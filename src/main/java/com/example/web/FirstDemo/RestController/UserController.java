package com.example.web.FirstDemo.RestController;

import com.example.web.FirstDemo.Mapper.UserMapper;
import com.example.web.FirstDemo.Model.User;
import com.example.web.FirstDemo.redis.RedisService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ApplicationContext applicationContext;
    private final RedisService redisService;

    @Autowired
    public UserController(
            ApplicationContext applicationContext,
            RedisService redisService) {
        this.applicationContext = applicationContext;
        this.redisService = redisService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        UserMapper userMapper = this.applicationContext.getBean(UserMapper.class);

        userMapper.insertUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        System.out.println(String.format("request url: %s", url));

        List<User> users = (List<User>) this.redisService.getFromRedis(url);
        response.setHeader("dataSource", "redis");

        if (users == null) {
            UserMapper userMapper = this.applicationContext.getBean(UserMapper.class);
            users = userMapper.getAllUsers();

            this.redisService.saveToRedis(url, users, 10, TimeUnit.SECONDS);
            System.out.println("save data to redis");

            response.setHeader("dataSource", "mysql");
        }

        return users;
    }
}
