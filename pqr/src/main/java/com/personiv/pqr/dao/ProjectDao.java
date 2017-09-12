package com.personiv.pqr.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personiv.pqr.model.Project;

@Repository
@Transactional(readOnly = false)
public class ProjectDao extends JdbcDaoSupport{
	private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        jdbcTemplate = getJdbcTemplate();
    }
    
    public List<Project> getProjects() {
		String query  = "call _proc_getProjects()";
		List<Project> projects = jdbcTemplate.query(query,new BeanPropertyRowMapper<Project>(Project.class));
		return projects;
	}

	public Project addProject(Project project) {
		
		String query  = "call _proc_addProject(?)";
		
		jdbcTemplate.update(query,new Object[] {project.getName()});
		
		return project;
	}

	public Project getProject(int id) {
		
		String query  = "call _proc_getProjectById(?)";
		Project project = null;
		
		try {
			project = jdbcTemplate.queryForObject(query,new Object[] {id},new BeanPropertyRowMapper<Project>(Project.class));
		}catch(EmptyResultDataAccessException e) {
			
		}
		
		return  project;
	}
}
