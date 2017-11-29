package com.Employee_Profile.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.Employee_Profile.domain.Department;

@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String name;
	private int age;
	private String socialSecurityNumber;
	private double salary;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "departmentid")
	private Department department;
	
	public Employee(){}
	
	public Employee(String name, int age, String socialSecurityNumber, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.socialSecurityNumber = socialSecurityNumber;
		this.salary = salary;
	}
	
	

	public Employee(String name, int age, String socialSecurityNumber, double salary, Department department) {
		super();
		this.name = name;
		this.age = age;
		this.socialSecurityNumber = socialSecurityNumber;
		this.salary = salary;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

	@Override
	public String toString() {
		if(this.department != null)
			return "Employee [name=" + name + ", age=" + age + ", socialSecurityNumber="
				+ socialSecurityNumber + ", salary=" + salary + ", department=" + this.getDepartment() + "]";
		else
			return "Employee [name=" + name + ", age=" + age + ", socialSecurityNumber="
			+ socialSecurityNumber + ", salary=" + salary + "]";
			
	}
	
	

}
