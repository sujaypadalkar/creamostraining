package com.training.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EMPLOYEE_EMAIL")
public class EmailAddress {
	
	@Id
	@SequenceGenerator(name="EMPLOYEE_EMAIL_SEQ", sequenceName="EMPLOYEE_EMAIL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_EMAIL_SEQ")
	@Column(name="ID")
	private Long id;
	
	@Column(name="EMAIL")
	private String email;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "EMP_NO")
	@JsonIgnore
	private Employee employee;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailAddress [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	
}
