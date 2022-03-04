package com.zensar.beans;

public class Department {
	private String name;
	private String head;
	
	public Department() {
	}
	
	public Department(String name, String head) {
		this.name = name;
		this.head = head;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String toString() {
		return name + " - " + head;
	}
}
