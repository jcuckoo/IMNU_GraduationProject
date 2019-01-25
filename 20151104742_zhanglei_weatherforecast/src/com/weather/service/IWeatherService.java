package com.weather.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.Weather;


public interface IWeatherService {
	
	
	/**
	 * 查询天气列表
	 * 
	 * @param weather
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Weather> queryList(Weather weather, Boolean nameLikeModel, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询天气列表数
	 * 
	 * @param weather
	 * @return
	 */
	public int queryCount(Weather weather, Boolean nameLikeModel);
	
	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public Weather queryById(Long id);

	/**
	 * 新增
	 * 
	 * @param weather
	 * @return
	 */
	public boolean save(Weather weather);

	/**
	 * 删除天气
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);
	
	/**
	 * 删除所有数据
	 * 
	 * @return
	 */
	public boolean deleteAll();

}
