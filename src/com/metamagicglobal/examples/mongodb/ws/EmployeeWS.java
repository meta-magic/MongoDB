package com.metamagicglobal.examples.mongodb.ws;

import java.util.List;

import com.metamagicglobal.examples.mongodb.entity.Employee;

public interface EmployeeWS {
	
	public List<Employee> getAllEmployeeService();

	public Employee getEmployeeService(String id);

}
