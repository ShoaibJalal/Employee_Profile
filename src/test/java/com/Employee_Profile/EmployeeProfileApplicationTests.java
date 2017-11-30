package com.Employee_Profile;

import com.Employee_Profile.web.*;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeProfileApplicationTests {
	
	@Autowired
	private EmployeeController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
