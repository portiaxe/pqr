package com.personiv.pqr.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personiv.pqr.model.Role;
import com.personiv.pqr.model.User;
@Repository
@Transactional(readOnly = false)
public class UserDao extends JdbcDaoSupport{
	protected final static Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    
	private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        jdbcTemplate = getJdbcTemplate();
    }
    
	public List<User> getUsers() {
		String query  = "call GetUsers()";
		String query2 = "call GetUserRoles(?)";
		
		List<User> users = jdbcTemplate.query(query,new BeanPropertyRowMapper<User>(User.class));
		for(User u: users) {
			List<Role> roles = jdbcTemplate.query(query2,new Object[]{u.getId()},new BeanPropertyRowMapper<Role>(Role.class));		
			u.setRoles(roles);
		}
		return users;
	}

	public User getUserById(Integer id) {
		
		String query  = "call GetUserById(?)";
		User user = null;
		
		try {
		 user = jdbcTemplate.queryForObject(query,new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));		
		}catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

}
