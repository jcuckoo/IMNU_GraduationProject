package com.qst.dao;

import java.util.List;

import com.qst.bean.User;

public interface SelectUserDao {
	public List<User> getUserByBean(User userInfo);
	//查看用户列表，主要用于后台

	public List<User> getSelectUserByBean(User userInfo);
	//根据需要，搜索用户列表，目前用于后台

}
