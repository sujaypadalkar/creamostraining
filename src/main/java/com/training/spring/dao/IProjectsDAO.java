package com.training.spring.dao;

import java.util.List;

import com.training.spring.model.Project;

public interface IProjectsDAO {

	public List<Project> getAllProjects();
	
	public void createProject();
}
