package com.Employee_Profile.domain;

public class Employee {
	
	private String name;
	private int age;
	private String socialSecurityNumber;
	private double salary;
	
	public Employee(){}
	
	public Employee(String name, int age, String socialSecurityNumber, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.socialSecurityNumber = socialSecurityNumber;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", socialSecurityNumber=" + socialSecurityNumber
				+ ", salary=" + salary + "]";
	}
	
	

}
