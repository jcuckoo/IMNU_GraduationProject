package com.qst.bean;

public class User {
	private int user_id;
	private	String user_name;
	private String user_money;
	private String user_phone;
	private String user_pass;
	
	public User(){
	}
	
	public User(int user_id, String user_name, String user_money, String user_phone, String user_pass) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_money = user_money;
		this.user_phone = user_phone;
		this.user_pass = user_pass;
	
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_money() {
		return user_money;
	}

	public void setUser_money(String user_money) {
		this.user_money = user_money;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	
}
