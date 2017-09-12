package com.personiv.pqr.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personiv.pqr.model.Member;

@Repository
@Transactional(readOnly = false)
public class MemberDao  extends JdbcDaoSupport{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        jdbcTemplate = getJdbcTemplate();
    }
    
    public List<Member> getMembers(){
    	String query = "call _proc_getMembers()";
    	return  jdbcTemplate.query(query,new BeanPropertyRowMapper<Member>(Member.class));
    }
}
