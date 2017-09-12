package com.personiv.pqr.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class User{
	private int id;
	private String fname;
	private String lname;
	private String email;
	private Date created;
	private Date deleted;
	private Date updated;
	private List<Role> roles;
	
	
}
