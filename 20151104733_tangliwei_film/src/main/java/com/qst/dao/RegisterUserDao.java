package com.qst.dao;

import com.qst.bean.User;

/*
 * �û�ע��
 */
public interface RegisterUserDao {
	
	public int RegisterByBean(User userInfo);
	
	public int updateByBean(User userInfo);
}
