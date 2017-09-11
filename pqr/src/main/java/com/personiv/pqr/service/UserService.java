package com.personiv.pqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personiv.pqr.dao.UserDao;
import com.personiv.pqr.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers() {
		List<User>users = userDao.getUsers();
		return users;
	}
	public User getUserById(Integer id) {
		User user = userDao.getUserById(id);
		return user;
	}

}
