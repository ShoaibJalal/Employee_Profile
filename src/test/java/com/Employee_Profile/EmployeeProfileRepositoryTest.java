package com.Employee_Profile;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Employee_Profile.domain.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeProfileRepositoryTest {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void findBySocialSecurityNumberShouldReturnSocialSecurityNumber(){
		List<Employee> employees = (List<Employee>)repository.findAll();
		
		assertThat(employees).hasSize(2);
		assertThat(employees.get(1).getDepartment().getName()).isEqualTo("IT");
		
	}
	
	@Test
	public void createNewEmployee(){
		Employee employee = new Employee("Scarlet Lee",23 ,"22.04.93-2ww4", 2300.00,new Department("IT"));
		repository.save(employee);
		assertThat(employee.getId()).isNotNull();
}

}
