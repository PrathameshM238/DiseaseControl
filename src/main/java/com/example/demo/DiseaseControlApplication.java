package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class DiseaseControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiseaseControlApplication.class, args);
	}
	
	 @LoadBalanced
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();}

}
