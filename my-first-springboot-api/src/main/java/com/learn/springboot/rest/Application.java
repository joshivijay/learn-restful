package com.learn.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */

@SpringBootApplication
public class Application {
	static {
		System.setProperty("myjdbc.property", "static_sys_prop");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
