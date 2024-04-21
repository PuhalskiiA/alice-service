package com.example.aliceservice;

import com.example.aliceservice.skill.util.UUIDParser;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
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
