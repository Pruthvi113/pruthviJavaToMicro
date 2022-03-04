package com.zensar.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blog Application",version="v1",description = "My Blog Application")) //Swagger API
public class SpringBootBlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogAppApplication.class, args);
	}

	
}
