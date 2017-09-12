package com.personiv.pqr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ResourceServerConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("userpwd").roles("USER")
			.and()
			.withUser("admin").password("adminpwd").roles("ADMIN")
			/* FIXME : check_token api validates client credentials via basic authorization */
			.and()
			.withUser("foo").password("123").roles("CLIENT");
		
		auth.parentAuthenticationManager(authenticationManager);
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","/login","/assets/**",
				     "/bower_components/**","/vendor/**",
				     "/ng","/ng/**","/partials",
				     "/Projects/**",
				     "/Positions/**",
				     "/Departments/**",
				     "/Users/**",
				     "/DepartmentProjects/**",
				     "/Members/**",
				     "/partials/**","/Task/**","/user").permitAll()
		.anyRequest().authenticated();
		//.anyRequest().permitAll();			
	}
}
