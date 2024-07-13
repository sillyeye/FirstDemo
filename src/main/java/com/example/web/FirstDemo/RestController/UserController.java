package com.example.web.FirstDemo.RestController;

import com.example.web.FirstDemo.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 0;i < 10;++i) {
            users.add(new User("user-name-" + i, 30 + i));
        }

        return users;
    }
}
