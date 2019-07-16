package com.arnab.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration			// Enables as Spring Configuration class. Will be picked up during Component Scanning.
@EnableWebSecurity		// Enables as Spring Web Security class as app configuration.
public class EmployeeSecurity extends WebSecurityConfigurerAdapter {
	
	/**
	 * The class WebSecurityConfigurerAdapter is the basic class to implement the Spring Security using OAuth2.0.
	 * It has main three configure methods which we have implemented below.
	 * Please check one by one.
	 * 
	 * 1. The first method is the configure(WebSecurity web). It is the security related to web flow and web resources. It is not concerned the HTTP web paths.
	 * See in the method body. It ignores all the resources under /resources/ directory for security. Rest of the resources will secured under this.
	 * 
	 * 2. The second method is the configure(HttpSecurity http). It is the method related to HTTP security, like the paths. Where you have to authenticate and 
	 * authorize yourself before accessing any path or URL. The flow is self-explanatory.
	 * 
	 * 3. The third method is the configure(AuthenticationManagerBuilder auth). It is the method which is responsible to authenticate and authorize you via username and
	 * password. It is currently configured to use an in memory authentication system using default username and password admin and admin respectively. The username
	 * and password are embedded in the source code as you can see. So this is not a safe practise and is just being used to development and testing purpose.
	 * 
	 * 4. The fourth method is a static method, which provides a Password Encoder. As password hashes are being stored by OAuth2.0. So your password's equivalent hash value
	 * is stored. This is achieved through this class. This class is deprecated and do not use in real life applications. This is just for development and testing purposes.
	 * If you remove the method, the application will throw an error mentioning no password encoder. You can check by commenting out the method.
	 */

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/")
			.permitAll()
			.antMatchers("/employee/get", "/employee/save")
			.hasAnyRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll();
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.authorities("ROLE_ADMIN");
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
