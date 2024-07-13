package com.example.web.FirstDemo.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @GetMapping("/test")
    public String hello() {
        return "Hello, World! test";
    }

    @GetMapping("/school")
    public String school() {
        return "School";
    }

    @GetMapping("/students")
    public List<String> students() {
        return this.getStudentsFromMySql();
    }

    private List<String> getStudentsFromMySql() {
        List<String> students = new ArrayList<>();

        for (int i = 0;i < 10;++i) {
            students.add("student-" + i);
        }

        return students;
    }
}
