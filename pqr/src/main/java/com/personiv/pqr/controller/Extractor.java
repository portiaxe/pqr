package com.personiv.pqr.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.personiv.pqr.model.User;

public class Extractor implements ResultSetExtractor<User>{

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		User u = null;
	
		
		if(!rs.wasNull()) {
			while(rs.next()) {
				u = new User();
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
			}
		}
		return u;
	}

}
