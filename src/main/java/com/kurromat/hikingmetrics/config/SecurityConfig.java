package com.kurromat.hikingmetrics.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/webjars/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and().formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and().logout()
				.permitAll();
	}
}
