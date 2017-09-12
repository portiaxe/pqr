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

import com.personiv.pqr.model.Department;
import com.personiv.pqr.model.DepartmentProject;
import com.personiv.pqr.model.Member;
import com.personiv.pqr.model.Project;
import com.personiv.pqr.model.Target;

@Repository
@Transactional(readOnly = false)
public class DepartmentProjectDao extends JdbcDaoSupport{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        jdbcTemplate = getJdbcTemplate();
    }
    
    public List<DepartmentProject> getDepartmentProjects(){
    	String query = "call _proc_getDeptProjects()";
    	List<DepartmentProject> deptProjects = jdbcTemplate.query(query,new BeanPropertyRowMapper<DepartmentProject>(DepartmentProject.class));	
    	
    	for(DepartmentProject dp: deptProjects) {
    		
    		try {
    			
    			Project p = jdbcTemplate.queryForObject("call _proc_getProjectById(?)",new Object[] {dp.getProjectId()},new BeanPropertyRowMapper<Project>(Project.class));
    			Department d = jdbcTemplate.queryForObject("call _proc_getDeptById(?)",new Object[] {dp.getDepartmentId()},new BeanPropertyRowMapper<Department>(Department.class));
    			
    			List<Target> targets =jdbcTemplate.query("call _proc_getDeptProjectTargets(?)",new Object[] {dp.getId()},new BeanPropertyRowMapper<Target>(Target.class));
    			
    			dp.setProject(p);
    			dp.setDepartment(d);
    			dp.setTargets(targets);
    		}catch(EmptyResultDataAccessException e) {
				System.out.println(e.getMessage());
			}
    	}
    	return  deptProjects;
    }

	public DepartmentProject getDepartmentProject(int id) {
		String query = "call _proc_getDeptProjectById(?)";
    	
		DepartmentProject deptProject = null;
	
		try {
			 deptProject = jdbcTemplate.queryForObject(query,new Object[] {id},new BeanPropertyRowMapper<DepartmentProject>(DepartmentProject.class));	
	    		
			Project p = jdbcTemplate.queryForObject("call _proc_getProjectById(?)",new Object[] {deptProject.getProjectId()},new BeanPropertyRowMapper<Project>(Project.class));
			Department d = jdbcTemplate.queryForObject("call _proc_getDeptById(?)",new Object[] {deptProject.getDepartmentId()},new BeanPropertyRowMapper<Department>(Department.class));
			
			List<Target> targets =jdbcTemplate.query("call _proc_getDeptProjectTargets(?)",new Object[] {deptProject.getId()},new BeanPropertyRowMapper<Target>(Target.class));
			
			deptProject.setProject(p);
			deptProject.setDepartment(d);
			deptProject.setTargets(targets);
		}catch(EmptyResultDataAccessException e) {
			
			System.out.println(e.getMessage());
			return null;
		}
    	
    	return  deptProject;
	}

	public List<Target> getDepartmentProjectTargets(int id) {
		String query = "call _proc_getDeptProjectTargets(?)";
		List<Target> targets =jdbcTemplate.query(query,new Object[] {id},new BeanPropertyRowMapper<Target>(Target.class));	
		return targets;
	}
    
    
    
   
    
    
    
   
}
