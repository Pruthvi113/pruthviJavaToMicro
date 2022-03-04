package com.zensar.studentapp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2) //order in which this will be executed e.g if there are other runners, this will be 2nd one
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner implemented method"+Arrays.toString(args));		

	}

}
