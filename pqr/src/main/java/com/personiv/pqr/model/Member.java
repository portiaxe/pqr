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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Date getDeleted() {
		return deleted;
	}
	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}
	
}
