package com.training.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.training.spring.model.Employee;

@Repository("jEmpDAO")
//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
public class EmployeeDAO extends CommonDAO implements IEmployeeDAO {

	//@Resource(name="txTemplate")
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		String sql = "Select * from Employee";
		List<Map<String, Object>> results = getJdbcTemplate().queryForList("Select * from Employee");
		Object[] params = null;
		List<Employee> employees = getJdbcTemplate().query(sql, params, new EmployeeRowMapper());
		System.out.println(results);
		System.out.println(employees);
		return employees;
	}
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public void createEmployee(){
		final Employee employee = new Employee();
//		transactionTemplate.execute(new TransactionCallback<Employee>() {
//			public Employee doInTransaction(TransactionStatus ts) {
//				
//				try {
//					
//					
//					
//				} catch (Exception e) {
//					ts.setRollbackOnly();
//				}
//				return employee;
//			}
//		});
		
		employee.setEmployeeNum(10008L);
		employee.setFirstName("Jack");
		employee.setLastName("Ryan");
		employee.setDesignation("Software Developer");
//		employee.setSalary(4500D);
		String insertSql = "INSERT INTO EMPLOYEE(EMP_NO, FIRST_NAME,LAST_NAME, SALARY, DESIGNATION) VALUES (?, ?, ?, ?)";
		Object[] params =  {
				 employee.getEmployeeNum(), 
				 employee.getFirstName(), 
				 employee.getLastName(), 
//				 employee.getSalary(), 
				 employee.getDesignation()
		};
		
//		int[] types =  {
//				Types.NUMERIC,
//				Types.VARCHAR,
//		};
		getJdbcTemplate().update(insertSql, params);
	}
	
	private final class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmployeeNum(rs.getLong("EMP_NO"));
			employee.setFirstName(rs.getString("FIRST_NAME"));
			employee.setLastName(rs.getString("LAST_NAME"));
			employee.setDesignation(rs.getString("DESIGNATION"));
//			employee.setSalary(rs.getDouble("SALARY"));
			return employee;
		}
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee getEmployeeByNumber(Long empNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/** 
	 * 
	 */
}
