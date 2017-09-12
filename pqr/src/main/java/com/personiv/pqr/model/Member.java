package com.personiv.pqr.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private int id;
	private String name;
	private Date created;
	private Date update;
	private Date deleted;
	
}
