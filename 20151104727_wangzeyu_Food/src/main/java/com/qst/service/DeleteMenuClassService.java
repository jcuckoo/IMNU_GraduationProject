package com.qst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.MenuClass;
import com.qst.dao.DeleteMenuClassDao;

@Service
public class DeleteMenuClassService {
	
	@Autowired
	private DeleteMenuClassDao deleteMenuClassDao;
	
	public int Delete(MenuClass menuclassInfo) {
		
		return deleteMenuClassDao.getDeleteMenuClassByBean(menuclassInfo);
	}

}
