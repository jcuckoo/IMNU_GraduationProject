package com.qst.dao;

import java.util.List;

import com.qst.bean.Root;



public interface RootLoginDao {
	
	public List<Root> getRootLoginByBean(Root userInfo);
}
