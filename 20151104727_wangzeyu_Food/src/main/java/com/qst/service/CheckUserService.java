package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.User;
import com.qst.dao.CheckUserDao;

@Service
public class CheckUserService {
	
	@Autowired
	private CheckUserDao checkUserDao;
	public List<User> check(User userInfo){
		return checkUserDao.getUserByBean(userInfo);
	}
	
public List<User> selectUser(User userInfo){
		
		return checkUserDao.getCheckUserByBean(userInfo);
	}  
	

}
