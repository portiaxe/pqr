package com.personiv.pqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
}
