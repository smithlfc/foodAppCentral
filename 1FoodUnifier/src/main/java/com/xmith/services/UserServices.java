package com.xmith.services;

import com.xmith.models.Users;

public interface UserServices {
	
	public String getUserId(String username);
	public boolean updateTokenService(String username,String token);
	public Users getuserService(String userid);
	public String[] authenticateUser(String username);
	public boolean updateAttemptsService(String userid,String attempts);

	

}
