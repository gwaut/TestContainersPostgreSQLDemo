package com.example.TestContainersPostgreSQLDemo.domain;

public class Customer {
	
	private String firstName;
	private String lastName;
	
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	

}
