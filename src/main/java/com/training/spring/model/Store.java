package com.training.spring.model;

public class Store {

	private Customer cust;

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Store [cust=");
		builder.append(cust);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
