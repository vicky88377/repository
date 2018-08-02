package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.EmployeeApplication;
import com.example.demo.Service.EmployeeServiceImpliment;
import com.example.demo.model.Employee;
import com.example.demo.model.Response;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmployeeApplication.class)
@SpringBootTest
public class EmployeeControllerTest {
	private MockMvc mockMvc;
	
	@Mock
	private EmployeeServiceImpliment mockEmpService;
	
	@InjectMocks
	private EmployeeController empController;
	
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp1 () throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(empController).build();

	} 

	@Test
	public void testgetAllEmpDetails() throws Exception {
		Collection <Employee> emp = new LinkedList<Employee>();
		 emp.add( new Employee(1, "vikas", "abcd", "vikas s", "abc@mindtree.com","16/06/94", "Male", "country", "india"));
		String result="{ \"status\": \"Success \", \"message\": \"success\", \"statusCode\": \"200\", \"employees\": [ { \"id\": 1, \"username\": \"vikas\", \"password\": \"abcd\", \"fullname\": \"vikas s\", \"emailid\": \"abc@mindtree.com\", \"dateOfBirth\": \"16/06/94\", \"gender\": \"Male\", \"securityQuestion\": \"country\", \"answer\": \"india\" }] }";
		when(mockEmpService.findAll()).thenReturn(emp);
	
		mockMvc.perform(get("/EmpMgt/getAllEmpDetails"))
		//.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().is2xxSuccessful())
	    .andExpect(content().json(result)); 
	}
	
	
	//test negetive get employee details 
	
	@Test
	public void testnegetivegetAllEmpDetails() throws Exception {
		Collection <Employee> emp = new LinkedList<Employee>();
		// emp.add( new Employee(1, "vikas", "abcd", "vikas s", "abc@mindtree.com","16/06/94", "Male", "country", "india"));
		String result="{ \"status\": \"Success\", \"message\": \"no record present in database\", \"statusCode\": \"100\", \"employees\":null }";
		when(mockEmpService.findAll()).thenReturn(emp);
	
		mockMvc.perform(get("/EmpMgt/getAllEmpDetails"))
		//.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().is2xxSuccessful())
	    .andExpect(content().json(result)); 
	}
	
	@Test
	public void GetAllEmpException() throws Exception {
		List<Employee> emp = new LinkedList<Employee>();

		Mockito.doThrow(RuntimeException.class).when(mockEmpService).findAll();
		String result="{ \"status\": \"Failure\", \"message\": \"Exception while fetching recore from db\", \"statusCode\": \"400\", \"employees\": null }";

		mockMvc.perform(get("/EmpMgt/getAllEmpDetails")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json(result));

		
	}
	
	
	
	@Test
	public void testgetByEmpId() throws Exception {
	
		Employee emp = new Employee(5, "vikas", "abcd", "vikas s", "abc@mindtree.com","06/04/1992", "Male", "country", "india");
     String result ="{ \"status\": \"Success \", \"message\": \"success\", \"statusCode\": \"200\", \"employees\": [ { \"id\": 1, \"username\": \"vikas\", \"password\": \"abcd\", \"fullname\": \"vikas s\", \"emailid\": \"abc@mindtree.com\", \"dateOfBirth\": \"16/06/94\", \"gender\": \"Male\", \"securityQuestion\": \"country\", \"answer\": \"india\" }] }";
     when(mockEmpService.findOne(5)).thenReturn(emp);
		mockMvc.perform(get("/EmpMgt/getByEmpId/{empId}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().is2xxSuccessful());
			//	.andExpect(content().json(result));
	}
	
	
	@Test
	public void verifyInvalidEmployeeId() throws Exception {
		String reslt ="{ \"status\": \"Success \", \"message\": \"success\", \"statusCode\": \"200\", \"employees\": []}";
		String uri = "/EmpMgt/getByEmpId/{id}";
		Integer id = Integer.MAX_VALUE;
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri, id).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = result.getResponse().getStatus();
		//Assert.assertEquals("falure-excepted status", 404, status);
	}


	
	@Test
	public void verifyGetEmpbyidException() throws Exception {
		String result="{ \"status\": \"fail\", \"message\": \"Input data mismatch\", \"statusCode\": \"400\", \"employees\": null }";
		//String result ="{ \"status\": \"fail\", \"message\": \"Input data mismatch\", \"statusCode\": \"400\", \"employees\": null}";
		when(mockEmpService.findOne(Matchers.anyInt())).thenThrow(RuntimeException.class);
		mockMvc.perform(MockMvcRequestBuilders.get("/EmpMgt/getByEmpId/{empId}", 1)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		//		.andExpect(status().is4xxClientError())
				.andExpect(content().json(result));
	}


@Test
public void deleteEmployee() throws Exception{
	String Result=	"{ \"status\": \"Successful\", \"message\": \"Employee data successfully deleted\", \"statusCode\": \"200\", \"employees\": null }";
	Mockito.doNothing().when(mockEmpService).delete(Matchers.anyInt());
	
	mockMvc.perform(MockMvcRequestBuilders.delete("/EmpMgt/deleteEmp/101")).andExpect(status().isOk())
	.andExpect(content().json(Result));
	

	
}

@Test
@Rollback
public void DeleteByIdNegetive() throws Exception {
	String Result="{ \"status\": \"fail\", \"message\": \"Input data mismatch\", \"statusCode\": \"400\", \"employees\": null }";
	Mockito.doThrow(RuntimeException.class).when(mockEmpService).delete(Matchers.anyInt());
	
	mockMvc.perform(MockMvcRequestBuilders.delete("/EmpMgt/deleteEmp/101"))
	//.andExpect(status().isBadRequest())
	.andExpect(content().json(Result));
	
}


@Test
public void addEmptest() throws Exception {
	Employee emp = new Employee(1, "vikas", "abcd", "vikas s", "abc@mindtree.com","16/06/94", "Male", "country", "india");
	 String input= "{ \"id\": \"1\", \"username\": \"vikas\", \"password\": \"abcd\", \"fullname\": \"vikas s\", \"emailid\": \"abc@mindtree.com\", \"dateOfBirth\": \"16/06/94\", \"gender\": \"male\", \"securityQuestion\": \"country\", \"answer\": \"india\" } ";
	 String result="{ \"status\": \"Success \", \"message\": \"Employee data inserted successfully\", \"statusCode\": \"200\", \"employees\": [ { \"id\": 1, \"username\": \"vikas\", \"password\": \"abcd\", \"fullname\": \"vikas s\", \"emailid\": \"abc@mindtree.com\", \"dateOfBirth\": \"16/06/94\", \"gender\": \"Male\", \"securityQuestion\": \"country\", \"answer\": \"india\" }] } ";
	 when(mockEmpService.create(Matchers.any(Employee.class))).thenReturn(emp);
	 mockMvc.perform(MockMvcRequestBuilders.post("/EmpMgt/addEmp") 
             .contentType(MediaType.APPLICATION_JSON_VALUE).content(input)
                 .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(result));   
	 
	 } 
@Test
public void negetiveAddEmployee() throws Exception {
	Employee emp = new Employee(1, "vikas", "abcd", "vikas s", "abc@mindtree.com","16/06/94", "Male", "country", "india");
	String input= "{ \"id\": \"1\", \"username\": \"vikas\", \"password\": \"abcd\", \"fullname\": \"vikas s\", \"emailid\": \"abc@mindtree.com\", \"dateOfBirth\": \"16/06/94\", \"gender\": \"male\", \"securityQuestion\": \"country\", \"answer\": \"india\" } ";
	String Result="{ \"status\": \"fail\", \"message\": \"Input data mismatch\", \"statusCode\": \"400\", \"employees\": null }";
	when(mockEmpService.create(Matchers.any(Employee.class))).thenThrow(RuntimeException.class);
	mockMvc.perform(MockMvcRequestBuilders.post("/EmpMgt/addEmp") 
			.contentType(MediaType.APPLICATION_JSON_VALUE).content(input)
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(content().json(Result)); 
	
}

@Test
public void testCheckLogin() throws Exception
{
	
	Employee emp = new Employee(1, "vikas", "abcd", "vikas s", "abc@mindtree.com","16/06/94", "Male", "country", "india");
	String input ="{\"userName\": \"vikas\",\"password\": \"abcd\"}";
	String result ="{\"statusCode\": 200,\"status\": \"Success\",\"message\": \"Employee authentication successful\",\"emp\":null}";
	when(mockEmpService.checkLogin((Matchers.any(Employee.class)))).thenReturn(emp);
	mockMvc.perform(MockMvcRequestBuilders.post("/EmpMgt/checkLogin") 
			.contentType(MediaType.APPLICATION_JSON_VALUE).content(input)
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().is2xxSuccessful());
			//.andExpect(content().json(result)); 	
}

@Test
public void verifyCheckLoginMethodException2() throws Exception
{
	
	Employee emp = new Employee(1, "vikas", "abcd", "vikas s", "abc@mindtree.com","16/06/94", "Male", "country", "india");
	String input ="{\"userName\": \"vikas\",\"password\": \"abcd\"}";
	String result ="{\"statusCode\": 400,\"status\": \"Failure\",\"message\": \"Exception while fetching recore from db\",\"emp\":null}";
	when(mockEmpService.checkLogin((Matchers.any(Employee.class)))).thenThrow(RuntimeException.class);
	mockMvc.perform(MockMvcRequestBuilders.post("/EmpMgt/checkLogin") 
			.contentType(MediaType.APPLICATION_JSON_VALUE).content(input)
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().is2xxSuccessful());
		//	.andExpect(content().json(result)); 	
}



}





