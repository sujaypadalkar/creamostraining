package com.training.spring.model;
 
public class Customer{
	
	private String firstName;
	
	private String lastName;
	
	private Address address;

	public Customer(Address address){
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}

	/*public void setAddress(Address address) {
		this.address = address;
	}*/
	
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
	
}