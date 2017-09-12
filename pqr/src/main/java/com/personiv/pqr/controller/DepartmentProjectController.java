package com.personiv.pqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personiv.pqr.model.DepartmentProject;
import com.personiv.pqr.model.Target;
import com.personiv.pqr.service.DepartmentProjectService;

@RestController
public class DepartmentProjectController {
	
	@Autowired
	private DepartmentProjectService deptProjService;
	
	@RequestMapping(path = "/DepartmentProjects",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DepartmentProject> getDepartmentProjects(){
		return deptProjService.getDepartmentProjects();
	}
	
	@RequestMapping(path = "/DepartmentProjects/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DepartmentProject getDepartmentProject(@PathVariable("id") int id){
		return deptProjService.getDepartmentProject(id);
	}
	
	@RequestMapping(path = "/DepartmentProjects/Target/Project/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Target> getDepartmentProjectTargets(@PathVariable("id") int id){
		return deptProjService.getDepartmentProjectTargets(id);
	}
}
