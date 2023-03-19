package com.luv2code.springdemo.mvc.customer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotNull(message="Firstname is required")
	@Size(min=1, message="Firstname is required")
	private String firstName;
	
	@NotNull(message="Lastname is required")
	@Size(min=1, message="Lastname is required")
	private String lastName;
	
	@Min(value=0, message="must be greater or equal to zero")
	@Max(value=10, message="must be lesser or equal to ten")
	private int freePasses;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
}
