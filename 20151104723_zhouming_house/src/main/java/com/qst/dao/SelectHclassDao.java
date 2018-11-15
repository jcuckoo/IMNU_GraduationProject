package com.qst.dao;

import java.util.List;

import com.qst.bean.Hclass;



public interface SelectHclassDao {
	
	public List<Hclass> getHclassByBean(Hclass hclassInfo);

}
