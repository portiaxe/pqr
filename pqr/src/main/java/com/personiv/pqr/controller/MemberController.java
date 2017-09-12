package com.personiv.pqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personiv.pqr.model.Member;
import com.personiv.pqr.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memService;
	
	@RequestMapping(path = "/Members",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Member> getMembers(){
		return memService.getMembers();
	}
}
