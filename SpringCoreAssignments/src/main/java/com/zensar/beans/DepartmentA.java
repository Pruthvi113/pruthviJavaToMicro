package com.zensar.beans;

public class DepartmentA {
	private String name;
	private String head;
	
	public DepartmentA() {
	}
	
	public DepartmentA(String name, String head) {
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
