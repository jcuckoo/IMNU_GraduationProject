package com.qst.dao;

import java.util.List;

import com.qst.bean.User;

public interface SelectUserDao {
	public List<User> getUserByBean(User userInfo);
	//�鿴�û��б���Ҫ���ں�̨

	public List<User> getSelectUserByBean(User userInfo);
	//������Ҫ�������û��б�Ŀǰ���ں�̨

}
