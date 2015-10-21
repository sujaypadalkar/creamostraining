package com.training.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
@NamedQueries(value={@NamedQuery(name="employeeByNum", query="SELECT employeeNum, firstName, lastName, designation FROM Employee where employeeNum = :employeeNum")})
public class Employee {

	public Employee(){
		//default constructor 
	}
	public Employee(Long employeeNum, String firstName, String lastName,
			String designation) {
		this.employeeNum = employeeNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
	}

	@Id
	@SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName="EMPLOYEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
	@Column(name="EMP_NO")
	private Long employeeNum;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private Salary salary;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="employee", cascade=CascadeType.ALL)
	private Set<EmailAddress> emailAddresses = new HashSet<EmailAddress>();

	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_PROJECTS", 
			   joinColumns={@JoinColumn(name="EMP_NO")}, 
			   inverseJoinColumns={@JoinColumn(name="PROJECT_ID")})
	private Set<Project> projects = new HashSet<Project>();
	
	public Long getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(Long employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	
	public Set<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(Set<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeNum=");
		builder.append(employeeNum);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", emailAddresses=");
		builder.append(emailAddresses);
		builder.append(", projects=");
		builder.append(projects);
		builder.append("]");
		return builder.toString();
	}

	
}
