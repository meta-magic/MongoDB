package com.metamagicglobal.examples.mongodb.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.*;

@Document
public class Employee {

	@Id
	@Field	
	private String id;

	@Field
	private String name;

	@Field
	private String email;

	@Field
	private int age;

	@ElementCollection
	private List<Address> address = new ArrayList<Address>();

	public List<Address> getAddress() {
		return address;
	}

	public void setOfcAddress(List<Address> address) {
		this.address = address;
	}

	public Employee(String id, String name, String email, int age, ArrayList<Address> address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		String addr = "";
		for (Address adr : address) {
			addr = addr.concat(adr.toString());
			addr = addr.concat("\t");
		}
		return "\n******************************************************************\n\t Employee Information :=" + id
				+ ", name:=" + name + ", age:=" + age + ", email:= " + email + "\n" + " \t Employee Address" + addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
