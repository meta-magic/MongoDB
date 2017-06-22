package com.metamagicglobal.examples.mongodb.test;

import java.util.ArrayList;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metamagicglobal.examples.mongodb.entity.Address;
import com.metamagicglobal.examples.mongodb.entity.Employee;
import com.metamagicglobal.examples.mongodb.repository.EmployeeRepository;
import com.metamagicglobal.examples.mongodb.repository.EmployeeRepositoryImpl;

public class EmployeeMain {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");

		EmployeeRepository repository = context.getBean(EmployeeRepositoryImpl.class);

		ArrayList<Address> address = new ArrayList<Address>();
		address.add(new Address("home addr", 22235));
		address.add(new Address("ofc addr", 21345));

		ArrayList<Address> address2 = new ArrayList<Address>();
		address2.add(new Address("home addr 2", 22235));
		address2.add(new Address("ofc addr 2", 21345));

		repository.saveEmployee(new Employee("1", "aaa", "a@y.com", 10, address));
		repository.saveEmployee(new Employee("2", "bbb", "b@y.com", 3, address2));

		System.out.println("Displaying all Employees " + repository.getAllEmployee());

		System.out.println("Find Employee with EMPID:1" + repository.getEmployee("1"));

		repository.updateEmployee("1", "abc");

		System.out.println("Displaying all Employees after update EMPID:1" + repository.getAllEmployee());

		repository.updateEmployee("1", "a@y.com", "zzz");
		
		repository.deleteEmployee("2");

		System.out.println("Displaying all Employees after deleting EMPID:2 " + repository.getAllEmployee());

	}
}
