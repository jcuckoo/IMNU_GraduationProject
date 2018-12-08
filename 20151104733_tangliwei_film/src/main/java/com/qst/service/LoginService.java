package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.User;
import com.qst.dao.UserLoginDao;

@Service
public class LoginService {
	
	@Autowired
	private UserLoginDao userloginDao;
	
	public List<User> Login(User userInfo){
		
		return userloginDao.getUserLoginByBean(userInfo);
	}
	
}
