package com.infy.avon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AvonProductDetailsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvonProductDetailsAppApplication.class, args);
	}
}
