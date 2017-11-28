package com.Employee_Profile.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long > {
	
	List<Employee> findBySocialSecurityNumber(String socialSecurityNumber);

}
