package com.example.aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication@EnableCaching
public class AspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectApplication.class, args);
	}

}
