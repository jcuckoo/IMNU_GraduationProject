package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.Menu;
import com.qst.dao.SelectMenuDao;

@Service
public class SelectMenuService {
	
	@Autowired
	private SelectMenuDao selectMenuDao;
	
	public List<Menu> select(Menu menuInfo){
		return selectMenuDao.getMenuByBean(menuInfo);
	}
	
	public List<Menu> selectMenu(Menu menuInfo){
		
		return selectMenuDao.getSelectMenuByBean(menuInfo);
	}

}
