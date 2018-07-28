package com.xmith.dao;

import java.util.List;

import com.xmith.models.UserAccount;
import com.xmith.models.UserAttempts;
import com.xmith.models.UserDetails;
import com.xmith.models.Users;

public interface UserDataServices {
	public String getUserId(String username);
	public int updateToken(String username,String tokenid);
	public Users getUser(String userid);
	public Object []  getuserlogindao(String username);
	public int updateAttempts(String userid,String attempts);
	//for inserts
	public String saveUsers(Users users);
	public String saveUsersDetails(UserDetails userdetails);
	public String saveUsersAttempts(UserAttempts userAttempts);
    //for user accounts
	public List<UserAccount> getUserAccounts(String UserId);
}
