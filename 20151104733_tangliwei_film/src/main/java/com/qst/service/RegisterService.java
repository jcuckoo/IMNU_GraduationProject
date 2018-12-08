package com.qst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.User;
import com.qst.dao.RegisterUserDao;

/*
 * ÓÃ»§×¢²á
 */
@Service
public class RegisterService {

	@Autowired
	private RegisterUserDao registerUserDao;
	
	public int Register(User userInfo) {
		return registerUserDao.RegisterByBean(userInfo);
	}
	
	public int Update(User userInfo){
		return registerUserDao.updateByBean(userInfo);
	}
}
