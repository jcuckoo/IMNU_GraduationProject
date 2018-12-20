package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.model.*;

@Service
public class YoukeService {
	@Autowired
	private YoukeDao youkeDao;

	public List queryYoukes(Youke record,String youkeName,int page,int rows, String sdate, String edate) {
		// TODO Auto-generated method stub
		return youkeDao.getYoukeList(record,youkeName,page,rows,sdate,edate);
	}

	public Youke getYouke(int parseInt) {
		// TODO Auto-generated method stub
		return youkeDao.getYoukeById(parseInt);
	}

	public void modifyYouke(Youke youke) {
		// TODO Auto-generated method stub
		youkeDao.update(youke);
	}

	public void deleteYouke(Integer id) {
		// TODO Auto-generated method stub
		youkeDao.delete(id);

	}

	public void save(Youke youke) {
		// TODO Auto-generated method stub
		youkeDao.add(youke);

	}

}
