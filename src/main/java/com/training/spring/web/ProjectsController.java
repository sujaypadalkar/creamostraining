package com.training.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.spring.model.Project;
import com.training.spring.service.ProjectsService;

@Controller
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;
	
	@RequestMapping(path="/projects", method=RequestMethod.GET)
	public @ResponseBody List<Project> getAllProjects(){
		List<Project> projects = projectsService.getAllProjects();
 		return projects;
	}
}
