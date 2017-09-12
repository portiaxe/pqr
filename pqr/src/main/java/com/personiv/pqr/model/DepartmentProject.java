package com.personiv.pqr.model;


import java.sql.Date;

import lombok.Data;

@Data
public class DepartmentProject {
	private int id;
	private Date created;
	private Date updated;
	private Date deleted;
	private Project project;
	private Department department;
	private int departmentId;
	private int projectId;



}
