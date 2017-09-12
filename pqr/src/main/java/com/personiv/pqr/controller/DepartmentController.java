package com.personiv.pqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personiv.pqr.model.Department;
import com.personiv.pqr.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(path = "/Departments",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getDepartments(){
		return deptService.getDepartments();
	}
}
