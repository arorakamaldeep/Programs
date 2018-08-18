package com.java.problems;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{
	private int id;
	private String name;
	Employee(int id, String name){
		this.id=id;
		this.name=name;				
	}
	public int getId() {
		return id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	@Override
	public int compare(Employee emp, Employee emp2) {
		// TODO Auto-generated method stub
		return emp.getName().compareToIgnoreCase(emp2.getName());
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	

}
