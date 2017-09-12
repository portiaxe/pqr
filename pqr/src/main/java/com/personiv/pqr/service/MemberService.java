package com.personiv.pqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personiv.pqr.dao.MemberDao;
import com.personiv.pqr.model.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memDao;
	
	public List<Member> getMembers(){
		return memDao.getMembers();
	}
}
