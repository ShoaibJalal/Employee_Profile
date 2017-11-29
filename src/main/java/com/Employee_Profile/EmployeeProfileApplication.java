package com.Employee_Profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Employee_Profile.domain.*;


@SpringBootApplication
public class EmployeeProfileApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeProfileApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProfileApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner EmployeeDemo(EmployeeRepository erepository, DepartmentRepository drepository) {
		return (args) -> {
			log.info("saving few departments");
			drepository.save(new Department("IT"));
			drepository.save(new Department("HR"));
			drepository.save(new Department("Operations"));
			
			erepository.save(new Employee("Chan Lee",21 ,"22.03.96-2ww4", 2300.00,drepository.findByName("IT").get(0)));
			erepository.save(new Employee("Sarah kate",23, "30.01.94-33s4", 2224.00,drepository.findByName("HR").get(0)));	
			
			log.info("fetch all Employees");
			for (Employee employee : erepository.findAll()) {
				log.info(employee.toString());
			}

		};
	}
}
