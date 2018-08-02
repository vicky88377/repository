package com.example.demo.Service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.demo.model.Employee;

public class EmployeeServiceImplimentTest {

	
	@Test
	public void testFindAll() {
		List<Employee> employeelist = new ArrayList<Employee>();
		Employee employee1 = new Employee();
		employee1.setId(4);
		employee1.setUsername("gautam");
		employee1.setPassword("1234");
		employee1.setFullname("gambhir");
		employee1.setEmailid( "em@gm");
		employee1.setDateOfBirth( "16-04-1994");
		employee1.setGender("male");
		employee1.setSecurityQuestion("male");
		employee1.setAnswer("male");
		Employee employee2 = new Employee();
		employee2.setId(5);
		employee2.setUsername("vikas");
		employee2.setPassword("1234");
		employee2.setFullname("saini");
		employee2.setEmailid( "em@gm");
		employee2.setDateOfBirth( "16-04-1994");
		employee2.setGender("male");
		employee2.setSecurityQuestion("question");
		employee2.setAnswer("answer");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void checkLogin()
	{
		Employee employee1 = new Employee();
		employee1.setUsername("vikas");
		employee1.setPassword("1234");
	//	Employee employee=EmployeeServiceImpliment.checkLogin("vikas", "1234");
		//assertEquals("vikas", employee.getUsername());
		//assertEquals("1234", employee.getPassword());
		
	}


}
