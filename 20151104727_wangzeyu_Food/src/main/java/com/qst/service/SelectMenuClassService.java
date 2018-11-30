package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.MenuClass;
import com.qst.dao.SelectMenuClassDao;


@Service
public class SelectMenuClassService {
	
	@Autowired
	private SelectMenuClassDao selectMenuClassDao;
	

	public List<MenuClass> select(MenuClass menuclassInfo) {

		return selectMenuClassDao.getMenuClassByBean(menuclassInfo);
	}

}
