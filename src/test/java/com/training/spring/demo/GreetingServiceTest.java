package com.training.spring.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.spring.greeting.GreetingService;
import com.training.spring.greeting.GreetingServiceImpl;

public class GreetingServiceTest {

	private ApplicationContext context;
	
	@Before
	public void setup(){
		try {
			context = new ClassPathXmlApplicationContext("beans.xml");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
	
	@Test
	public void testSayGreeting(){
		GreetingService greetingService = (GreetingService) context.getBean("greetingService");
		greetingService.sayGreeting();
	}
	
	@Test
	public void testSayGreetingInEnglish(){
		GreetingServiceImpl greetingService = (GreetingServiceImpl) context.getBean("greetingService");
		greetingService.setGreeting("Hello Spring Rookie !");
		greetingService.sayGreeting();
	}
}
