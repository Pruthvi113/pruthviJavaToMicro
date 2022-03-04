package com.zensar.blog.util;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id ="myEndPoint")
public class MyEndPoint {

	@ReadOperation
	public String hello() {
		return "Hello from custom end point";
	}
}
