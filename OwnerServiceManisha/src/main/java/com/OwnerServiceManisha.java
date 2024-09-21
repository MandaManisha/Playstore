package com;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OwnerServiceManisha{

	public static void main(String[] args) {
		SpringApplication.run(OwnerServiceManisha.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {

		return new ModelMapper();
	}

}
