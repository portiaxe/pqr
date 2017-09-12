package com.personiv.pqr.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Target {
	private int id;
	private int projectId;
	private int positionId;
	private Position position;
	private double begginerProductivity;
	private double beginnerQuality;
	private double moderateProductivity;
	private double moderateQuality;
	private double experiencedProductivity;
	private double experiencedQuality;
	private Date created;
	private Date updated;
	private Date deleted;
}
