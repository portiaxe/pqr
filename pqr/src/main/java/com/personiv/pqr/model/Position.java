package com.personiv.pqr.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2288879982532327219L;
	private int id;
	private String name;
	private Date created;
	private Date updated;
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
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getDeleted() {
		return deleted;
	}
	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}