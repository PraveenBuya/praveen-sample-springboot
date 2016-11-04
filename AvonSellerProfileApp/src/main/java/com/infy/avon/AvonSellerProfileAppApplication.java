package com.infy.avon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan({"com.infy.avon"})
public class AvonSellerProfileAppApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.config.name","application");
		SpringApplication.run(AvonSellerProfileAppApplication.class, args);
	}
}
