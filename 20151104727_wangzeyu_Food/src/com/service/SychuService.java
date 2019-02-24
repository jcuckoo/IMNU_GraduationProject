package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.model.*;

@Service
public class SychuService {
	@Autowired
	private SychuDao sychuDao;

	public List querySychus(Sychu record,int page,int rows, String sdate, String edate) {
		// TODO Auto-generated method stub
		return sychuDao.getSychuList(record,page,rows,sdate,edate);
	}

	public Sychu getSychu(int parseInt) {
		// TODO Auto-generated method stub
		return sychuDao.getSychuById(parseInt);
	}

	public void modifySychu(Sychu sychu) {
		// TODO Auto-generated method stub
		sychuDao.update(sychu);
	}

	public void deleteSychu(Integer id) {
		// TODO Auto-generated method stub
		sychuDao.delete(id);

	}

	public void save(Sychu sychu) {
		// TODO Auto-generated method stub
		sychuDao.add(sychu);

	}

}
