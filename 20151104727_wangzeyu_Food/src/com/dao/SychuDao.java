package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class SychuDao extends SqlSessionDaoSupport{

	public List getSychuList(Sychu record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SychuMapper sychuMapper = (SychuMapper) app.getBean("sychuMapper");
		List<Sychu> list = sychuMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Sychu getSychuById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SychuMapper sychuMapper = (SychuMapper) app.getBean("sychuMapper");
		Sychu sychu = sychuMapper.selectByPrimaryKey(id);
		
		return sychu;
	}

	public void update(Sychu sychu) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SychuMapper sychuMapper = (SychuMapper) app.getBean("sychuMapper");
		sychuMapper.updateByPrimaryKey(sychu);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SychuMapper sychuMapper = (SychuMapper) context.getBean("sychuMapper");
		sychuMapper.deleteByPrimaryKey(id);
	}

	public void add(Sychu sychu) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SychuMapper sychuMapper = (SychuMapper) context.getBean("sychuMapper");
		sychuMapper.insert(sychu);
		
	}
}
