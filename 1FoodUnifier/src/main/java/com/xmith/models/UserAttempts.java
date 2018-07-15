package com.xmith.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ATTEMPT_HIS")
public class UserAttempts {
	@Id
	private String user_id;
	private String user_attempts;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_attempts() {
		return user_attempts;
	}
	public void setUser_attempts(String user_attempts) {
		this.user_attempts = user_attempts;
	}
	
	
	

}
