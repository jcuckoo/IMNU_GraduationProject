package com.qst.dao;

import java.util.List;

import com.qst.bean.MenuClass;


public interface SelectMenuClassDao {
	
	public List<MenuClass> getMenuClassByBean(MenuClass menuclassInfo);

}
