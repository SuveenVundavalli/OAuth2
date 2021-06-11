package com.sinch.ws.api.photoresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PhotoResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoResourceServerApplication.class, args);
	}

}
