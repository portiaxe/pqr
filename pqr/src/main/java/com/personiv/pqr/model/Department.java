package com.personiv.pqr.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Department {
	private int id;
	private String name;
	private Date created;
	private Date updated;
	private Date deleted;
}
