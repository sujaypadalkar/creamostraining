package com.training.spring.greeting;

public class GreetingServiceImpl implements GreetingService {
	
	private String greeting;

	public GreetingServiceImpl() {
	}

	public GreetingServiceImpl(String greeting) {
		this.greeting = greeting;
	}

	public void sayGreeting() {
		System.out.println(getGreeting());
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GreetingServiceImpl [greeting=");
		builder.append(greeting);
		builder.append("]");
		return builder.toString();
	}
	
	
}
