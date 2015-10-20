package com.training.spring.dao;

import java.util.List;

import com.training.spring.model.Employee;

public interface IEmployeeDAO {

	public List<Employee> getAllEmployees();
	
	public void createEmployee();
	
	public Employee getEmployeeByNumber(Long empNumber);
	
	public void updateEmployee();
}
