package com.personiv.pqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personiv.pqr.model.User;
import com.personiv.pqr.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/Users",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(){
		List<User> users  = userService.getUsers();
		return users;
	}
	
	@RequestMapping(path = "/User/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserById(@PathVariable("id") Integer id){
		return userService.getUserById(id);		
	}
}
