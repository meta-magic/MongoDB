package com.metamagicglobal.examples.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.metamagicglobal.examples.mongodb.entity.Employee;
import com.mongodb.WriteResult;
import com.metamagicglobal.examples.mongodb.repository.EmployeeRepository;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * Get All Employees
	 */
	public List<Employee> getAllEmployee() {
		return mongoTemplate.findAll(Employee.class);
	}

	/**
	 * Save All Employees
	 */
	public void saveEmployee(Employee emp) {
		mongoTemplate.insert(emp);
	}

	/**
	 * findById
	 */
	public Employee getEmployee(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
				Employee.class);
	}

	/**
	 * UpdatebyId
	 */
	public WriteResult updateEmployee(String id, String name) {
		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("name", name), Employee.class);
	}
	
	/**
	 * UpdateByIdAndEMail
	 * */
	public WriteResult updateEmployee(String id,String email, String name) {
		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id).and("email").is(email)),
				Update.update("name", name), Employee.class);
	}

	/**
	 * DeleteById
	 */
	public void deleteEmployee(String id) {
		mongoTemplate
				.remove(new Query(Criteria.where("id").is(id)), Employee.class);
	}
}
