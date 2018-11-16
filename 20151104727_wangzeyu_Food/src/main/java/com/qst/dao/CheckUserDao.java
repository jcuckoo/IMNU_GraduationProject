package com.qst.dao;

import java.util.List;

import com.qst.bean.User;

public interface CheckUserDao {
	public List<User> getUserByBean(User userInfo);
	
	public List<User> getCheckUserByBean(User userInfo);

}
