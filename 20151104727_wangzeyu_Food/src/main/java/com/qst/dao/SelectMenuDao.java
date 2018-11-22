package com.qst.dao;

import java.util.List;

import com.qst.bean.Menu;


public interface SelectMenuDao {
	
	public List<Menu> getMenuByBean(Menu menuInfo);
	
	public List<Menu> getSelectMenuByBean(Menu menuInfo);

}
