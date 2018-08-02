package com.example.demo.Service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.example.demo.Service.*;
import com.example.demo.DAO.*;
import com.example.demo.model.Employee;

import junit.framework.Assert;

public class EmployeeServiceImplimentTest {

	@Mock
	private EmployeeDAO employeeDAO;
	@Autowired
	EmployeeServiceImpliment empService;
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
	public void checkLogin()
	{
		Employee employee1 = new Employee();
		employee1.setUsername("vikas");
		employee1.setPassword("1234");
	//	Employee employee=EmployeeServiceImpliment.checkLogin("vikas", "1234");
		//assertEquals("vikas", employee.getUsername());
		//assertEquals("1234", employee.getPassword());
		
	}
	
/*	@Test
	public void testFindOne() {
		Optional<Employee> e = null;
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
		e = Optional.of(employee1);
		when(employeeDAO.findById(23)).thenReturn(e);
		Employee employee = EmployeeServiceImpliment.findOne(23);
		assertEquals(23, employee.getId());
		assertEquals("vikas", employee.getUsername());
		assertEquals("abcd", employee.getPassword());
		
	}*/
	


}
