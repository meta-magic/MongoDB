package com.metamagicglobal.examples.mongodb.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metamagicglobal.examples.mongodb.entity.Employee;
import com.metamagicglobal.examples.mongodb.repository.EmployeeRepository;

public class EmployeeWSImpl implements EmployeeWS{
	@Autowired
	private EmployeeRepository repository;

	
	@Override
	@RequestMapping("/empList")
	public List<Employee> getAllEmployeeService() {
		return repository.getAllEmployee();
	}

	@Override
	@RequestMapping("/empId")
	public Employee getEmployeeService(@Param("id")String id) {
		// TODO Auto-generated method stub
		return repository.getEmployee(id);
	}

}
