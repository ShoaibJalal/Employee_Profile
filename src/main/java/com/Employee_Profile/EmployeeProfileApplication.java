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
	public CommandLineRunner EmployeeDemo(EmployeeRepository erepository, DepartmentRepository drepository, UserRepository urepository) {
		return (args) -> {
			log.info("saving few departments");
			drepository.save(new Department("IT"));
			drepository.save(new Department("HR"));
			drepository.save(new Department("Operations"));
			
			erepository.save(new Employee("Chan Lee",21 ,"22.03.96-2ww4", 2300.00,drepository.findByName("IT").get(0)));
			erepository.save(new Employee("Sarah kate",23, "30.01.94-33s4", 2224.00,drepository.findByName("HR").get(0)));
			
			// Creating Users and Admin ( admin/admin lee/lee kate/kate )
			User user1 = new User("lee", "$2a$04$F8wksoBQzI/IdPGgXVzi5.8N2cd1hUTLWLvFU3lnmF.8eVgKxGglW", "USER");
			User user2 = new User("admin", "$2a$04$22XzDO3K8/ypDcpB6gnsaOoSE/INAcEPksqaqN8W32sJDvZgLJ.6S", "ADMIN");
			User user3 = new User("kate", "$2a$04$Gp3RdeGji1nIMVS04luYweBeWQQs7bPppOhx.FqzEE4/IPs49ZGmK", "USER");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all Employees");
			for (Employee employee : erepository.findAll()) {
				log.info(employee.toString());
			}

		};
	}
}
