package com.sinch.ws.api.albumresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlbumResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumResourceServerApplication.class, args);
	}

}
