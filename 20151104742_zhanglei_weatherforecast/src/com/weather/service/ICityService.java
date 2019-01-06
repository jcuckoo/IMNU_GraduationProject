package com.weather.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.City;


public interface ICityService {
	
	
	/**
	 * 查询城市列表
	 * 
	 * @param city
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<City> queryList(City city, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询城市列表数
	 * 
	 * @param city
	 * @return
	 */
	public int queryCount(City city);
	
	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public City queryById(Long id);

	/**
	 * 新增/编辑
	 * 
	 * @param city
	 * @return
	 */
	public boolean saveOrUpdate(City city);

	/**
	 * 删除城市
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);
	
	/**
	 * 随机获取城市信息
	 * 
	 * @return
	 */
	public City queryByRand();

}
