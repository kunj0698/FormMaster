package com.Project.FormMaster.Security;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig
{
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
		
	@Bean
	public UserDetailsService getUserDetailService()
	{
		return new UserIMPL();		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		 http
		.authorizeHttpRequests()
		.requestMatchers("/assets/**").permitAll()
		.requestMatchers("/masterform","/masterUser").hasAuthority("Admin")
		
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(new AuthenticationSuccessHandler() 
		{			
			@SuppressWarnings("unchecked")
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					org.springframework.security.core.Authentication authentication)
					throws IOException, ServletException 
			{
				 List<String> user=(List<String>)request.getSession().getAttribute("authorities");
					
					if (user.contains("Admin")==false) 
					{				
						if(user.contains("User")==false) 
						{
						   response.sendRedirect("/fillform");
						}
						else 
						{
						   response.sendRedirect("/masterform");
						}
					}
				
			}
		})
		.permitAll()
		.and()
		.logout() 
        .logoutUrl("/logout") 
        .logoutSuccessUrl("/signin") 
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .and()
        .csrf().disable();
		
		return http.build();		 		
	}



}
