package com.qst.bean;

public class User {
	private int n_userid;
	private String n_username;
	private String n_password;
	private String n_tell;
	//private String n_address;
	
	public User() {
		
	}
	public User(int n_userid, String n_username, String n_password, String n_tell) {
		super();
		this.n_userid = n_userid;
		this.n_username = n_username;
		this.n_password = n_password;
		this.n_tell = n_tell;
	}
	public int getN_userid() {
		return n_userid;
	}
	public void setN_userid(int n_userid) {
		this.n_userid = n_userid;
	}
	public String getN_username() {
		return n_username;
	}
	public void setN_username(String n_username) {
		this.n_username = n_username;
	}
	public String getN_password() {
		return n_password;
	}
	public void setN_password(String n_password) {
		this.n_password = n_password;
	}
	public String getN_tell() {
		return n_tell;
	}
	public void setN_tell(String n_tell) {
		this.n_tell = n_tell;
	}
	
	

}
