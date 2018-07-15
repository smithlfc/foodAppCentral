package com.xmith.authAndAuthr;


import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.xmith.dao.UserDataServicesImpl;
import com.xmith.services.UserServices;

public class CustomAuthentacationProvider  implements AuthenticationProvider{
private static final Logger logger = LoggerFactory.getLogger(CustomAuthentacationProvider.class);
private UserServices services;
@Autowired
public void setServices(UserServices services) {
	this.services = services;
}
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try{
		String username=authentication.getName();
		String pass=(String)authentication.getCredentials();
		String[] authenticateUserArray = services.authenticateUser(username);
		if(authenticateUserArray==null){
		return null;	
		}
		if(!(username.isEmpty()||pass.isEmpty()) ){
		 //validate password and attempts service
		 if(authenticateUserArray[0].equals(username) && authenticateUserArray[1].equals(pass) && Integer.parseInt(authenticateUserArray[2])== 1 && Integer.parseInt(authenticateUserArray[4]) < 3){
	     UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, pass, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
	     return usernamePasswordAuthenticationToken;
		 }
		 else{
		logger.info("username/password/attempts wrong");
		int at=Integer.parseInt(authenticateUserArray[4])+1;
		boolean updateAttemptsService = services.updateAttemptsService(authenticateUserArray[5], at+"");
		if(updateAttemptsService){
		logger.info("user not updated");	
		}
		logger.info("Bad Credentials");
		}
		}
		else{
		logger.info("username or password is empty");	
		}
		}
		catch (Exception e){
		logger.info("authenticate Exception");	
		e.printStackTrace();
		throw new BadCredentialsException("Bad Credentials");
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
