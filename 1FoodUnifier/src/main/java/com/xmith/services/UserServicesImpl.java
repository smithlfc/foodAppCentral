package com.xmith.services;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xmith.dao.UserDataServices;
import com.xmith.dao.UserDataServicesImpl;
import com.xmith.models.UserAttempts;
import com.xmith.models.UserDetails;
import com.xmith.models.Users;


@Component
public class UserServicesImpl implements UserServices {

	private static final Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);
	
	@Autowired
	private UserDataServices dataservice;
	public void setDataservice(UserDataServices dataservice) {
		this.dataservice = dataservice;
	}
	
	
	@Override
	public String getUserId(String username) {
		// TODO Auto-generated method stub
		return dataservice.getUserId(username);
	}


	@Override
	public boolean updateTokenService(String username, String token) {
		logger.info("updateTokenService entry");
		int executeresult=dataservice.updateToken(username, token);
		if(executeresult==9){
			logger.info("updateTokenService exit");
			return false;
		}
		else{
			logger.info("updateTokenService exit");
			return true;
		}
		
	
	}


	@Override
	public Users getuserService(String userid) {
		logger.info("getuserService entry");
		
		logger.info("getuserService exit");
		return dataservice.getUser(userid);
	}


	@Override
	public String[] authenticateUser(String username) {
    logger.info("authenticateUser :Entry");
    Object[] getuserlogindao = dataservice.getuserlogindao(username);
    if(getuserlogindao==null){
    return null;	
    }
	return Arrays.copyOf(getuserlogindao,getuserlogindao.length , String[].class);
	}


	@Override
	public boolean updateAttemptsService(String userid, String attempts) {
    logger.info("updateAttemptsService : Entry");
    int executeresult=dataservice.updateAttempts(userid, attempts);
    if(executeresult==9){
	return true;
	}
	else{
    return false;
	}
    
    }

@Override
public boolean insertUserRegDetails(UserDetails userDetails) {
logger.info("insertUserRegDetails :Entry");	

String tem=dataservice.saveUsersDetails(userDetails);
logger.info("dummy print"+ tem);

		
logger.info("insertUserRegDetails :Exit");	
return false;
}




}
