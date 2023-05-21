package com.Project.FormMaster.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Project.FormMaster.Entity.UserMaster;
import com.Project.FormMaster.Service.UserMasterService;

import jakarta.servlet.http.HttpServletRequest;

public class UserIMPL implements UserDetailsService {
	
	@Autowired
	UserMasterService userMstService;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		UserMaster user=userMstService.findByEmail(email);
			
         if(user != null) 
         {				
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			
			request.getSession().setAttribute("MasterId", user.getUserMasterId());
			
			request.getSession().setAttribute("FirstName", user.getFirstName());				
							
			request.getSession().setAttribute("LastName", user.getLastName());
			
			request.getSession().setAttribute("Role", user.getRole());
	
			return new CustomUserDetails(user);
		}
			
		throw new UsernameNotFoundException("not found");
}

}
