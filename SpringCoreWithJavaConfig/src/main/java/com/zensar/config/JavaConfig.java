package com.zensar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zensar.Item;
import com.zensar.Order;

@Configuration
public class JavaConfig {
	
	@Bean(name="order") //will treat my method as a BEAN,
	//if bean name is NOT specificed, method name will be the bean name i.e getOrder here
	public Order getOrder() {
		//return new Order(new Item("Apple Laptop",25000.00), "Purchase Laptops");
		return new Order(getItem(), "Purchase Laptops");

	}
	
	@Bean
	public Item getItem() {
		return new Item("Dell Laptop",20000.00);
	}
}
