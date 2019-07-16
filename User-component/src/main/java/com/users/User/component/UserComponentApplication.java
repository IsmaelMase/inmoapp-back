package com.users.User.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SpringBootApplication
@EnableDiscoveryClient
@RestController()
@Api(tags = "zuul inside rest api")
public class UserComponentApplication {

	@GetMapping("/home")
	@ApiOperation(value = "demo Example")
	public String home() {
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(UserComponentApplication.class, args);
	}

}
