package com.xmith.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_details")
public class UserAccount {
private String user_id;
@Id
private String account_no;
private String account_type;
private String ifsc_no;
private String primary;
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getAccount_no() {
	return account_no;
}
public void setAccount_no(String account_no) {
	this.account_no = account_no;
}
public String getAccount_type() {
	return account_type;
}
public void setAccount_type(String account_type) {
	this.account_type = account_type;
}
public String getIfsc_no() {
	return ifsc_no;
}
public void setIfsc_no(String ifsc_no) {
	this.ifsc_no = ifsc_no;
}
public String getPrimary() {
	return primary;
}
public void setPrimary(String primary) {
	this.primary = primary;
}



}
