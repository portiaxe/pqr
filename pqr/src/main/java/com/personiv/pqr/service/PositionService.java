package com.personiv.pqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personiv.pqr.dao.PositionDao;
import com.personiv.pqr.model.Position;

@Service
public class PositionService {
	
	@Autowired
	private PositionDao posDao;
	
	
	public List<Position> getPositions() {		
		return posDao.getPositions();
	}

}
