package com.training.spring.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.model.EmailAddress;
import com.training.spring.model.Employee;
import com.training.spring.model.Salary;

@Repository("hEmpDAO")
public class HibernateEmployeeDAO extends CommonDAO implements IEmployeeDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
//		Session session = sessionFactory.openSession();
//		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.addOrder(Order.asc("designation"));
		List<Employee> employees = criteria.list();
//		tx.commit();
//		session.close();
		return employees;
	}
	
	public Employee getEmployeeByNumber(Long empNumber){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeNum", empNumber));
		Employee employee = (Employee)criteria.uniqueResult();
		return employee;
	}

	@Override
	@Transactional
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Jane");
		employee.setLastName("Morris");
		employee.setDesignation("Hibernate Developer");
		
		Salary salary = new Salary();
		salary.setSalary(5800D);
		salary.setEmployee(employee);
		employee.setSalary(salary);
		sessionFactory.getCurrentSession().save(employee);
		
	}
	
	@Transactional
	public void updateEmployee(){
		Employee emp = sessionFactory.getCurrentSession().get(Employee.class, 9954L);
		
		Employee employee = getEmployeeByNumber(9954L);
		EmailAddress email = new EmailAddress();
		email.setEmail("jane.morris@example.com");
		email.setEmployee(employee);
		
		Set<EmailAddress> emails = new HashSet<EmailAddress>();
		emails.add(email);
		employee.setEmailAddresses(emails);
		sessionFactory.getCurrentSession().update(employee);
	}
	
	
}
