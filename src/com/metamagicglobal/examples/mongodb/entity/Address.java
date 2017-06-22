package com.metamagicglobal.examples.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.*;

@Embeddable
public class Address {
	@Field
	private int pin;

	@Field
	private String address;

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address(String address, int pin) {
		this.pin = pin;
		this.address = address;
	}

	@Override
	public String toString() {
		return "\n\t Address :=" + address + ", pin:=" + pin;
	}
}