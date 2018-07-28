package com.xmith.services;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xmith.dao.UserDataServices;
import com.xmith.dao.UserDataServicesImpl;
import com.xmith.models.UserAccount;
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

String result1 =dataservice.saveUsersDetails(userDetails);
Users users= new Users();
users.setUser_id(result1);
users.setUser_name(userDetails.getUser_first_name());
users.setUser_password(userDetails.getUser_password());
users.setUser_enabled("1");
users.setUser_authority("ROLE_USER");
users.setUser_token("0");
String result2 =dataservice.saveUsers(users);
UserAttempts attempts= new UserAttempts();
attempts.setUser_id(result1);
attempts.setUser_attempts("0");
String result3 =dataservice.saveUsersAttempts(attempts);
if(result1!=null&&result2!=null&&result3!=null){
return true;	
}


		
logger.info("insertUserRegDetails :Exit");	
return false;
}


@Override
public List<UserAccount> getAccounts(String UserId) {
logger.info("getAccounts :Entry");
return  dataservice.getUserAccounts(UserId);
}




}
