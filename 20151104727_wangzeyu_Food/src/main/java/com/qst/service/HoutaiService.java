package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.Root;
import com.qst.dao.RootLoginDao;

@Service
public class HoutaiService {

	@Autowired
	private RootLoginDao rootloginDao;

	public List<Root> Login(Root rootInfo) {

		return rootloginDao.getRootLoginByBean(rootInfo);
	}
}
