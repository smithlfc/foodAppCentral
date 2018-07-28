package com.xmith.services;

import java.util.List;

import com.xmith.models.UserAccount;
import com.xmith.models.UserDetails;
import com.xmith.models.Users;

public interface UserServices {
	
	public String getUserId(String username);
	public boolean updateTokenService(String username,String token);
	public Users getuserService(String userid);
	public String[] authenticateUser(String username);
	public boolean updateAttemptsService(String userid,String attempts);
	public boolean insertUserRegDetails(UserDetails userDetails);
	public List<UserAccount> getAccounts(String UserId);

}
