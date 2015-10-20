package com.training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.dao.IEmployeeDAO;
import com.training.spring.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("hEmpDAO")
	private IEmployeeDAO employeeDAO;
	
	
	@Transactional
	public List<Employee> getAllEmployees(){
		List<Employee> emps = employeeDAO.getAllEmployees();
		System.out.println(emps);
		return emps;
	}
	
	@Transactional
	public Employee getEmployeeForEmpNo(Long empNumber){
		Employee emp = employeeDAO.getEmployeeByNumber(empNumber);
		return emp;
	}
}
