package com.metamagicglobal.examples.mongodb.repository;

import java.util.List;

import com.metamagicglobal.examples.mongodb.entity.Employee;
import com.mongodb.WriteResult;

public interface EmployeeRepository {

	public List<Employee> getAllEmployee();

	public void saveEmployee(Employee emp);

	public Employee getEmployee(String id);

	public WriteResult updateEmployee(String id, String name);

	public WriteResult updateEmployee(String id, String email, String name);

	public void deleteEmployee(String id);
}
