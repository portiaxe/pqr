package com.personiv.pqr.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6741692649195340777L;
	private int id;
	private String name;
	private Date created;
	private Date deleted;
	private Date updated;
}
