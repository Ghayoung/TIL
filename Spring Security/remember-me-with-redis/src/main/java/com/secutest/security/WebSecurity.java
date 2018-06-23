package com.secutest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("scott").password("tiger").roles("ROLE_USER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic()
		.and()
		.authorizeRequests()
			.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.usernameParameter("name")
			.passwordParameter("password")
			.defaultSuccessUrl("/")
			.failureUrl("/login?error")
			.permitAll();

	}

}