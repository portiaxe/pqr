package com.personiv.pqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personiv.pqr.dao.DepartmentProjectDao;
import com.personiv.pqr.model.DepartmentProject;
import com.personiv.pqr.model.Target;

@Service
public class DepartmentProjectService {
	
	@Autowired
	private DepartmentProjectDao depProjDao;
	
	public List<DepartmentProject> getDepartmentProjects(){
		return depProjDao.getDepartmentProjects();
	}

	public DepartmentProject getDepartmentProject(int id) {
		return depProjDao.getDepartmentProject(id);
	}

	public List<Target> getDepartmentProjectTargets(int id) {
		return depProjDao.getDepartmentProjectTargets(id);
	}
}
