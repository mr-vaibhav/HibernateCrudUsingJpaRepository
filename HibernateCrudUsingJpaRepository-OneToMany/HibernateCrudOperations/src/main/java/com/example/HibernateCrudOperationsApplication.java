package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages= {"com.example.model"})
public class HibernateCrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudOperationsApplication.class, args);
	}

}
