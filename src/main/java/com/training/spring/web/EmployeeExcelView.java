package com.training.spring.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.training.spring.model.Employee;

public class EmployeeExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Employee> employees = (List<Employee>)model.get("employees");
		int rowCount = 0;
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(rowCount++);
		row.createCell(0).setCellValue("Emp#");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("Last Name");
		row.createCell(3).setCellValue("Salary");
		row.createCell(4).setCellValue("Designation");
		
		for (Employee employee : employees) {
			row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(employee.getEmployeeNum());
			row.createCell(1).setCellValue(employee.getFirstName());
			row.createCell(2).setCellValue(employee.getLastName());
//			row.createCell(3).setCellValue(employee.getSalary());
			row.createCell(4).setCellValue(employee.getDesignation());
		}
	}
}
