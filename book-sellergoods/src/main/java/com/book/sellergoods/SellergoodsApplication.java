package com.book.sellergoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class SellergoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellergoodsApplication.class, args);
	}
}
