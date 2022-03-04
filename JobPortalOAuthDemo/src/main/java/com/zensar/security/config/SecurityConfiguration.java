package com.zensar.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // Add this annotation to an @Configuration class to have the Spring Securityconfiguration defined in any WebSecurityConfigurer or more likely by extendingthe WebSecurityConfigurerAdapter base class and overriding individual methods
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//This method is used for "AUTHENTICATION" purpose

		auth.userDetailsService(userDetailsService); 
		
			
	}*/
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//This method is used for "AUTHORIZATION" purpose
		http.csrf().disable() // this will disable CSRF so that Forbidden is not thrown
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login()
			;
	}
	

}
