package com.qst.dao;

import java.util.List;

import com.qst.bean.User;

/*
 * ÓÃ»§µÇÂ¼
 */
public interface UserLoginDao {

	public List<User> getUserLoginByBean(User userInfo);
	
}
