package com.avijit.together.status;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableScheduling
public class TogetherStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TogetherStatusApplication.class, args);
	}
}
