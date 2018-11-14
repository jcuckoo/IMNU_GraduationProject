package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.User;
import com.qst.dao.SelectUserDao;

@Service
public class SelectUserService {

	@Autowired
	private SelectUserDao selectUserDao;

	public List<User> select(User userInfo) {

		return selectUserDao.getUserByBean(userInfo);
	}
	
	public List<User> selectUser(User userInfo){
		
		return selectUserDao.getSelectUserByBean(userInfo);
	}
}
