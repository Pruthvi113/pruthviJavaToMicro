package com.zensar.beans;

public class Employee {
	
	
	private String name;
	
	private String id;
	
	private Department department;
	
	
	public Employee() {
		//System.out.println("Inside default constructor -  Employee ()");

	}

	public Employee (Department department) {
		super();
		//System.out.println("Inside parametreized constructor -  Employee (Department department)");
		this.department = department;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", department=" + department + "]";
	}
	
	
}
