package com.fulfillmentBridge.FbCustomerService.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/h2-console/**","/refreshToken/**").permitAll();
		http.authorizeRequests().antMatchers("/customers/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/customers/**").hasAuthority("USER");

		http.authorizeRequests().antMatchers(HttpMethod.GET,"/customers/**").hasAnyAuthority("USER");
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/customers/**").hasAnyAuthority("ADMIN");
		//http.authorizeRequests().antMatchers(HttpMethod.PATCH,"/customers/1").hasAnyAuthority("CUSTOMER_MANAGER");

		
		
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


	
		
		
	}

}
