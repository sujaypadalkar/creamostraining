package com.training.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.spring.model.Employee;
import com.training.spring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
 		return employees;
	}
	
	
	@RequestMapping(path="/employee/{empNo}", method=RequestMethod.GET)
	public @ResponseBody Employee getAllEmployeeForEmpNo(@PathVariable("empNo") Long empNumber){
		Employee employee = employeeService.getEmployeeForEmpNo(empNumber);
 		return employee;
	}
	
	@RequestMapping(path="/getAllEmployeesForExcel", method=RequestMethod.GET)
	public String getAllEmployeesForExcel(Model model){
		model.addAttribute("employees", getAllEmployees());
 		return "employeeXls";
	}


}
