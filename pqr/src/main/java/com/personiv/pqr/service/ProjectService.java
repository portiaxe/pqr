package com.personiv.pqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personiv.pqr.dao.ProjectDao;
import com.personiv.pqr.model.Project;

@Service
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	public List<Project> getProjects(){
		List<Project> projects = projectDao.getProjects();
		return projects;
	}
}
