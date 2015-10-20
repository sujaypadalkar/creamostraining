package com.training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.dao.IProjectsDAO;
import com.training.spring.model.Project;

@Service
public class ProjectsService {

	@Autowired
	@Qualifier("hProDAO")
	private IProjectsDAO projectsDAO;
	
	
	@Transactional
	public List<Project> getAllProjects(){
		List<Project> projects = projectsDAO.getAllProjects();
		return projects;
	}
}
