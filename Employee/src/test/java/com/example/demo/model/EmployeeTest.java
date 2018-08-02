package com.example.demo.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.EmployeeApplication;
import com.example.demo.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmployeeApplication.class)
@SpringBootTest
public class EmployeeTest {


	@Test
	public void testEmployee() {
		Employee employee = new Employee();
		Integer x=new Integer(4);
		
		employee.setId(4);
		employee.setUsername("gautam");
		employee.setPassword("1234");
		employee.setFullname("gambhir");
		employee.setEmailid( "em@gm");
		employee.setDateOfBirth( "16-04-1994");
		employee.setGender("male");
		employee.setSecurityQuestion("male");
		employee.setAnswer("male");
		
		assertEquals(employee.getId(), x);
		assertEquals(employee.getUsername(), "gautam");
		assertEquals(employee.getPassword(), "1234");
		assertEquals(employee.getFullname(), "gambhir");
		assertEquals(employee.getEmailid(), "em@gm");
		assertEquals(employee.getDateOfBirth(), "16-04-1994");
		assertEquals(employee.getGender(),"male");
		assertEquals(employee.getSecurityQuestion(),"male");
		assertEquals(employee.getAnswer(),"male");
		
		
		    String result = 	"Employee [id=" + 4 + ", username=" + "gautam" + ", password=" + "1234" + ", fullname=" + "gambhir"
					+ ", emailid=" + "em@gm" + ", dateOfBirth=" + "16-04-1994" + ", gender=" + "male" + ", securityQuestion="
					+ "male" + ", answer=" + "male" + "]";	  
		    		assertEquals(employee.toString(), result);
		    

		
		
		
	

	}
	
}