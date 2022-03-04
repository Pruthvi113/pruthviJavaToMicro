package com.zensar.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeA {
	
	
	private String name;
	
	private String id;
	
	@Qualifier(value = "departmentA2")
	@Autowired
	private DepartmentA departmentA;
	
	
	public EmployeeA() {
		//System.out.println("Inside default constructor -  Employee ()");

	}

	public EmployeeA (DepartmentA departmentA) {
		super();
		//System.out.println("Inside parametreized constructor -  Employee (Department department)");
		this.departmentA = departmentA;
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


	public DepartmentA getDepartmentA() {
		return departmentA;
	}


	public void setDepartmentA(DepartmentA departmentA) {
		this.departmentA = departmentA;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", departmentA=" + departmentA + "]";
	}
	
	
}
