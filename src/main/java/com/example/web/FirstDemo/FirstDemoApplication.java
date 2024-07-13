package com.example.web.FirstDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("hello wolrd");
		SpringApplication.run(FirstDemoApplication.class, args);
		while (true) {
			System.out.println("keep working");
			Thread.sleep(2000);
		}
	}

}
