package com.zensar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("item")
public class Item {
	@Value("${item.name}")
	private String name;
	
	@Value("${item.price}")
	private Double price;
	public Item() {
	}
	
	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String toString() {
		return name + " - " + price;
	}
}
