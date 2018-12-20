package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class YoukeDao extends SqlSessionDaoSupport{

	public List getYoukeList(Youke record,String youkename,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YoukeMapper youkeMapper = (YoukeMapper) app.getBean("youkeMapper");
		List<Youke> list = youkeMapper.selectAll(record,youkename,page,rows,sdate,edate);
		return list;
	}
	
	public Youke getYoukeById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YoukeMapper youkeMapper = (YoukeMapper) app.getBean("youkeMapper");
		Youke youke = youkeMapper.selectByPrimaryKey(id);
		
		return youke;
	}

	public void update(Youke youke) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YoukeMapper youkeMapper = (YoukeMapper) app.getBean("youkeMapper");
		youkeMapper.updateByPrimaryKey(youke);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YoukeMapper youkeMapper = (YoukeMapper) context.getBean("youkeMapper");
		youkeMapper.deleteByPrimaryKey(id);
	}

	public void add(Youke youke) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YoukeMapper youkeMapper = (YoukeMapper) context.getBean("youkeMapper");
		youkeMapper.insert(youke);
		
	}
}
