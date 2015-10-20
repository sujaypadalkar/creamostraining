package com.training.spring.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.training.spring.dao.IEmployeeDAO;
import com.training.spring.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class HibernateTest{

	@Autowired
	@Qualifier("hEmpDAO")
	private IEmployeeDAO empDAO;
	
	@Test
	public void testCreateEmployee() throws Exception{
		empDAO.createEmployee();
	}
	
	@Test
	public void testUpdateEmployee() throws Exception{
		empDAO.updateEmployee();
	}
	
	@Test
	public void testGetAllEmployees() throws Exception{
		List<Employee> employees = empDAO.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
}
