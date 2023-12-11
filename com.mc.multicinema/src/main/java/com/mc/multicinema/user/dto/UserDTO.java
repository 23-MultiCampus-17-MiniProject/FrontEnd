package com.mc.multicinema.user.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
	
	String user_id;
	String user_key;
	String user_email;
	String user_pw;
	String user_regdate;
	String user_birthday;
	String user_pw_salt;
	boolean is_deleted;
	String deleted_date;
	String user_name;
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_pw_salt() {
		return user_pw_salt;
	}
	public void setUser_pw_salt(String user_pw_salt) {
		this.user_pw_salt = user_pw_salt;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public String getDeleted_date() {
		return deleted_date;
	}
	public void setDeleted_date(String deleted_date) {
		this.deleted_date = deleted_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
