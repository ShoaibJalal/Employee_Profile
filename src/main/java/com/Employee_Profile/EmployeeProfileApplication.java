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
	public CommandLineRunner EmployeeDemo(EmployeeRepository erepository) {
		return (args) -> {
			log.info("save a couple of employees");
			erepository.save(new Employee("Chan Lee",21 ,"22.03.96-2ww4", 2300.00));
			erepository.save(new Employee("Sarah kate",23, "30.01.94-33s4", 2224.00));	
			
			log.info("fetch all Employee");
			for (Employee employee : erepository.findAll()) {
				log.info(employee.toString());
			}

		};
	}
}
