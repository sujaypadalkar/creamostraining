package com.training.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.spring.dao.IEmployeeDAO;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("beans.xml");
//			GreetingService greetingService = (GreetingService) context.getBean("greetingService");
//			greetingService.sayGreeting();
//			
//			Customer customer = (Customer) context.getBean("customer");
//			customer.setFirstName("Sujay");
//			customer.setLastName("Padalkar");
////			customer.getAddress().setFulladdress("123 Main Street, CA");
//			System.out.println(customer);
//			
//			Store store = (Store)context.getBean("store");
//			System.out.println(store.toString());
//			
			IEmployeeDAO dao = (IEmployeeDAO)context.getBean("employeeDAO");
//			dao.createEmployee();
			dao.getAllEmployees();
			
			/*
			int[] seq = {1, 4, 6, 7, 8, 9, 18, 21, 25, 3, 2, 8, 9, 20, 23, 6, 7, 8, 9, 18, 21, 25} ;
			
			int subArrayLength = 0;
			int lowerIndex = 0;
			int upperIndex = 0;
			int longestArrayLength=0;
			for (int i = 0; i < seq.length; i++) {
				if(i == 0) {
					subArrayLength++;
					continue;
				}
				
				if(seq[i] <= seq[i-1] || i == seq.length - 1){
					if(subArrayLength >= longestArrayLength){
						longestArrayLength = subArrayLength;
						upperIndex = i-1;
						lowerIndex = i - subArrayLength; 
					}
					subArrayLength = 1;
				}else{
					subArrayLength++;
				}
			}
			
			for (int i = lowerIndex; i <= upperIndex; i++) {
				System.out.println(seq[i]);
			}*/
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
}
