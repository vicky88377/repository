package com.example.demo.Service;

import java.util.Collection;

import com.example.demo.model.Employee;


public interface EmployeeServices {
	
	Collection<Employee> findAll();
	
	Employee findOne(int id);

	Employee create(Employee employee);

	//Employee update(Employee employee, int id);
	Employee checkLogin(Employee employee);

	void delete(int id);

}
