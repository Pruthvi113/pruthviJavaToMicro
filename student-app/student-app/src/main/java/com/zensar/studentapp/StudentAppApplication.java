package com.zensar.studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"in.zensar","com.zensar.studentapp"}) // if not specified it will search only for components in same/child package
public class StudentAppApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!!");
		
	
		SpringApplication.run(StudentAppApplication.class, args);
	}


}
