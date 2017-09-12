package com.personiv.pqr.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Project{
	private int id;
	private String name;
	private Date created;
	private Date deleted;
	private Date updated;
}
