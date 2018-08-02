package com.example.demo.model;

import java.util.Collection;

public class Response {

	private String status;
	private String message;
	private String statusCode;

	Collection<Employee> employees;

	public Response(String status, String message, String statusCode, Collection<Employee> employees) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.employees = employees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", employees=" + employees + "]";
	}

}
