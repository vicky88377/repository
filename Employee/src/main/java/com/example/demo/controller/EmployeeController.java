package com.example.demo.controller;
import java.util.Collection;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeeServices;
import com.example.demo.model.Employee;
import com.example.demo.model.Response;

@RestController
@RequestMapping("/EmpMgt")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServices employeeServices;
	@GetMapping(value = "/getAllEmpDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllEmpDetails() {
		
			try
			{
				Collection<Employee> employees = employeeServices.findAll();
				
				if (!employees.isEmpty())
				{
					return new Response("Success ", "success", "200", employees);
				}
				else
				{
					return new Response( "Success", "no record present in database","100", null);
				}
			}
			catch (Exception e)
			{
				return new Response( "Failure", "Exception while fetching recore from db","400",null);
			}
		} 
	/*@GetMapping(value = "/getAllEmp", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Employee> getAllDetails(){
		logger.info("Returning all the employees");
		return (List<Employee>) employeeServices.findAll();

	}*/
	
	/*@GetMapping(value ="/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeInfoById(@PathVariable(value = "id") Integer id) {
		logger.info("employee id to return " + id);
		return employeeServices.findOne(id);
	}*/

	@GetMapping(value = "/getByEmpId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getByEmpId(@PathVariable("id") int id) {
        	Collection<Employee> employees = new LinkedList<Employee>();
		try {
			Employee employee = employeeServices.findOne(id);
			employees.add(employee);
			return new Response("Success ", "[]", "200 ", employees);
		} catch (Exception e) {
			return new Response("fail", "Input data mismatch", "400", employees);
		}

	}
	// Create a new employee details
	/*@PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee createEmployeeDetails(@Valid @RequestBody Employee employees) {
		logger.info("Employee to save " + employees.toString());
		return employeeServices.create(employees);
	}*/

	@PostMapping(value = "/addEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addEmp(@RequestBody Employee Employee) {
		Collection<Employee> employees = new LinkedList<Employee>();
		try {
			Employee createdEmployee = employeeServices.create(Employee);
			employees.add(createdEmployee);
	    	return new Response("Success ", "Employee data inserted successfully", "200", employees);

		} catch (Exception e) {
			return new Response("failure", "Input data mismatch", "400", employees);
		}

	}
	
	
	// Delete a Employee details
	@DeleteMapping(value = "/deleteEmp/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response deleteEmp(@PathVariable("id") int id) {
		logger.info("ToDo id to remove " + id);
		try {
			employeeServices.delete(id);
			return new Response("Successful", "Employee data successfully deleted", "200", null);
		} catch (Exception e) {
			return new Response("fail", "Input data mismatch", "400", null);
		}

	}
	@PostMapping(value = "/checkLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkLogin(@RequestBody Employee employee) {
		boolean flag = employeeServices.checkLogin(employee);
		if (!flag) {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(HttpStatus.OK);

	}
}
