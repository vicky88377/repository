package com.example.demo.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.model.Employee;

@Service(value = "EmployeeServices")
public class EmployeeServiceImpliment implements EmployeeServices {

	@Autowired
   EmployeeDAO EmployeeDAO;

	@Override
	public Collection<Employee> findAll() {
		Collection<Employee> employeeDetails = (Collection<Employee>) EmployeeDAO.findAll();
		return employeeDetails;
	}

	@Override
	public Employee findOne(int id) {
		System.out.println("id value " + id);
		Employee employee = EmployeeDAO.findById(id).get();
		return employee;

	}

	@Override
	public Employee create(Employee employee) {
	
		System.out.println(employee.getId());
		Employee createdEmployee = EmployeeDAO.save(employee);
		return createdEmployee;
	}

	/*@Override
	public Employee update(Employee employeeDetials, int id) {

		Employee employee = EmployeeDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", id));

		employee.setNoOf100(employeeDetials.getNoOf100());
		employee.setNoOf50(employeeDetials.getNoOf50());
		employee.setNoOfMatchesPlayed(employeeDetials.getNoOfMatchesPlayed());
		employee.setNoOfWickets(employeeDetials.getNoOfWickets());
		Employee updatedEmployeeDetials = EmployeeDAO.save(employee);
		return updatedEmployeeDetials;
	}
*/
	@Override
	public void delete(int id) {
		EmployeeDAO.deleteById(id);

	
	}

	@Override
	public boolean checkLogin(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
