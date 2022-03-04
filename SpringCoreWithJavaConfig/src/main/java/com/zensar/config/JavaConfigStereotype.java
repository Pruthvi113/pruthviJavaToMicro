package com.zensar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zensar.Item;
import com.zensar.Order;

@Configuration
@ComponentScan("com.zensar")
@PropertySource("data.properties") // this property can also be set at Component level e.g in Order.java
public class JavaConfigStereotype {
	
	
}
