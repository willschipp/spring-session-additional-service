package com.example.boot;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	   @Override
	    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	        builder.inMemoryAuthentication()
	            .withUser("user").password("password").roles("USER");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .anyRequest().authenticated()
	            .and()
	            .requestCache()
	            .requestCache(new NullRequestCache())
	            .and()
	            .httpBasic();
	    }

//	    @Bean
//	    public HttpSessionStrategy httpSessionStrategy() {
//	        return new CookieHttpSessionStrategy();
//	    }	
	
}
