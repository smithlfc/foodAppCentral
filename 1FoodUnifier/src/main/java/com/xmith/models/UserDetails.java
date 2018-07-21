package com.xmith.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.xmith.annotations.CheckUserExist;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
@Id
@GenericGenerator(name="IdGen",strategy="com.xmith.CustomIdGen.IdGeneratorUserDetails")
@GeneratedValue(generator="IdGen")
private String user_id;
@Size(min=3,max=10,message="user first name must have max length 7")
@CheckUserExist()
private String user_first_name;
@Size(min=3,max=10,message="user last name must have max length 7")
private String user_last_name;
@NotNull(message="please enter valid user age")
private String user_age;
@Size(min=3,max=20,message="email max length is 20")
@Email(message="enter valid email")
private String user_email;
@NotEmpty(message="password invalid")
private String user_password;
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_first_name() {
	return user_first_name;
}
public void setUser_first_name(String user_first_name) {
	this.user_first_name = user_first_name;
}
public String getUser_last_name() {
	return user_last_name;
}
public void setUser_last_name(String user_last_name) {
	this.user_last_name = user_last_name;
}
public String getUser_age() {
	return user_age;
}
public void setUser_age(String user_age) {
	this.user_age = user_age;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}

	
}
