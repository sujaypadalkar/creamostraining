package com.training.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonDAO {

	@Autowired
	protected SessionFactory sessionFactory;
}
