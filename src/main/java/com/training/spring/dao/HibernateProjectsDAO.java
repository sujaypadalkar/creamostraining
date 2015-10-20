package com.training.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.spring.model.Project;

@Repository("hProDAO")
public class HibernateProjectsDAO extends CommonDAO implements IProjectsDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Project.class);
		List<Project> projects = criteria.list();
		return projects;
	}

	@Override
	public void createProject() {
		// TODO Auto-generated method stub
		
	}
	
	
}
