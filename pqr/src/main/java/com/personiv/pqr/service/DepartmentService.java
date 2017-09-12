package com.personiv.pqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personiv.pqr.dao.DepartmentDao;
import com.personiv.pqr.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao deptDao;
	
	public List<Department> getDepartments(){
		return deptDao.getDepartments();
	}
}
