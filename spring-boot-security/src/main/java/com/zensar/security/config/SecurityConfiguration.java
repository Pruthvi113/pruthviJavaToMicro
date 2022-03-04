package com.zensar.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity // Add this annotation to an @Configuration class to have the Spring Securityconfiguration defined in any WebSecurityConfigurer or more likely by extendingthe WebSecurityConfigurerAdapter base class and overriding individual methods
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//This method is used for "AUTHENTICATION" purpose
		
		//1> LDAP authentication
		//auth.ldapAuthentication(); 
		
		//2> DB based authentication
		auth.userDetailsService(userDetailsService); 
		
		//3> IN-MEMORY authentication
			/*auth.inMemoryAuthentication() 
				.withUser("gaurav")
				.password("gaurav123")
				.roles("ADMIN")
				.and()
				.withUser("rudra")
				.password("rudra123")
				.roles("USER")
				.and()
				.withUser("viha")
				.password("viha123")
				.roles("NONE");*/
			
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//This method is used for "AUTHORIZATION" purpose
		http.csrf().disable() // this will disable CSRF so that Forbidden is not thrown
			.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER","ADMIN")
			.antMatchers("/all","/authenticate").permitAll()
			.and()
			.formLogin();
			//.loginPage("login.html")  // if u have a custom login page.
			//.httpBasic();  check again whats pupose of this?
		
	}
	

	/*
	 * Added below method to fix server startup error -
	 * Field authenticationManager in com.zensar.security.controller.UserController
	 * required a bean of type
	 * 'org.springframework.security.authentication.AuthenticationManager' that
	 * could not be found.
	 * 
	 * Action:
	 * 
	 * Consider defining a bean of type
	 * 'org.springframework.security.authentication.AuthenticationManager' in your
	 * configuration.
	 */	
	  @Bean 
	  public AuthenticationManager getAuthenticationManager() throws Exception
	  { return super.authenticationManager(); 
	  }
	 


	//There is no PasswordEncoder mapped for the id "null" - to fix this error , created below method.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
