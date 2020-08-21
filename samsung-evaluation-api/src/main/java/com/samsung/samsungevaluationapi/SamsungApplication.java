package com.samsung.samsungevaluationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SamsungApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamsungApplication.class, args);
	}	

}
