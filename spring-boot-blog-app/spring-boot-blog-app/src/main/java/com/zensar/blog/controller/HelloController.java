package com.zensar.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String sayHello() {
		return "<h2>Welcome to Spring boot</h2>";
	}	
	
}
