package com.zensar.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Order {
	
	//@Qualifier("item") // if bean name/id is different and u want that
	@Autowired
	private Item item;
	
	private String title;
	
	public Order() {
	}
	public Order(Item item, String title) {
		this.item = item;
		this.title = title;
	}
	
	public Order (Item item) {
		super();
		System.out.println("Inside Order (Item item)");
		this.item = item;
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
