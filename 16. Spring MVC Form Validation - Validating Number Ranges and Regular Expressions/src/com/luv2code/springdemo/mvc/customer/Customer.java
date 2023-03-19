package com.luv2code.springdemo.mvc.customer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotNull(message="Firstname is required")
	@Size(min=1, message="Firstname is required")
	private String firstName;
	
	@NotNull(message="Lastname is required")
	@Size(min=1, message="Lastname is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater or equal to zero")
	@Max(value=10, message="must be lesser or equal to ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
