package com.zensar.studentapp;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component //wont be called if this is NOT mentioned COmponents are searched for in the same or chile package. it in different use/overrider @ComponentScan in requestor class i.e. XXAppApplication 	
@Order(1) //order in which this will be executed e.g if there are other runners, this will be 2nd one
public class MyApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner implemented method"+Arrays.toString(args.getSourceArgs()));		

	}

}
