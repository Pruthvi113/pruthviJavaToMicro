package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("order")
@Scope("singleton")
public class Order {
	
	@Autowired
	private Item item;
	
	@Value("${title}")
	private String title;
	public Order() {
		System.out.println("Inside Constructor Order()");
	}
	public Order(Item item, String title) {
		System.out.println("Inside Constructor Order(item, title)");

		this.item = item;
		this.title = title;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return title + " - " + item;
	}
	
	public void orderInit() {
		System.out.println("orderInit");
	}
	
	public void orderDestroy() {
		System.out.println("orderDestroy");
	}
}
