package com.example.aliceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AliceServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AliceServiceApplication.class, args);
	}

	@Bean
	public RestTemplate initialRestTemplate() {
        return new RestTemplate();
	}
}
