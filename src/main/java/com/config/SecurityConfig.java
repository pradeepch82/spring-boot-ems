package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	public SecurityConfig() {
	System.out.println("SecurityConfigure created...");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		 System.out.println("In configure  AuthenticationManagerBuilder  method...");
	
	auth.inMemoryAuthentication()
	.withUser("ram").password("{noop}ram").roles("ADMIN").and()
	.withUser("rahim").password("{noop}rahim").roles("FACULTY").and()
	.withUser("david").password("{noop}david").roles("STUDENT");
    		 
		 
		 
		 
		 
	}
	
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 System.out.println("In configure  HttpSecurity  method...");

	http.csrf()
	    .disable()
	    .authorizeRequests()
	    .antMatchers("/welcome").hasRole("ADMIN")
	    .antMatchers("/welcome/today").hasAnyRole("FACULTY","STUDENT")
	    .antMatchers("/greet").hasRole("STUDENT")
	    .and()
	    .formLogin();
	     //.httpBasic();
	     	
	}
	
}
