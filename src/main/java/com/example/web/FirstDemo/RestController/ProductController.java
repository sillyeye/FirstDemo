package com.example.web.FirstDemo.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/clothes")
    public Map<String, String> clothes() {
        Map<String, String> clothes = new HashMap<>();
        clothes.put("cloth-1", "cloth-a");
        clothes.put("cloth-2", "cloth-b");
        clothes.put("cloth-3", "cloth-c");

        return clothes;
    }
}
