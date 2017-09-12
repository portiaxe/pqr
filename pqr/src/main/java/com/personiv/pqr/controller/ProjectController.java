package com.personiv.pqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personiv.pqr.model.Project;
import com.personiv.pqr.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(path = "/Projects",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getProjects(){
		return 	projectService.getProjects();
	}
	
	@RequestMapping(path = "/Projects/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Project getProject(@PathVariable("id") int id){
		return 	projectService.getProject(id);
	}
	
	@RequestMapping(path = "/Projects/addProject",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Project addProject(@RequestBody Project project){
	 	
			projectService.addProject(project);		
		return project;
	}
	
	@RequestMapping(path = "/Projects/deleteProject",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Project deleteProject(@RequestBody Project project){
	 	
			projectService.addProject(project);		
		return project;
	}
	
}
