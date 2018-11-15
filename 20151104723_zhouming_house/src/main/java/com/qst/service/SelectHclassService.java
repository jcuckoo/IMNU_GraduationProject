package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.bean.Hclass;
import com.qst.dao.SelectHclassDao;





@Service
public class SelectHclassService {
	
	@Autowired
	private SelectHclassDao selectHclassDao;
	

	public List<Hclass> select(Hclass hclassInfo) {

		return selectHclassDao.getHclassByBean(hclassInfo);
	}

}
