package com.xmith.dao;

import java.util.List;

import com.xmith.models.Users;

public interface UserDataServices {
	public String getUserId(String username);
	public int updateToken(String username,String tokenid);
	public Users getUser(String userid);
	public Object []  getuserlogindao(String username);
	public int updateAttempts(String userid,String attempts);

}
