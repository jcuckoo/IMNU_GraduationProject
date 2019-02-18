package com.weather.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.City;


@Mapper
@Repository
public interface ICityMapper {
	
	/**
	 * 查询城市列表
	 * @param city
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<City> loads(
			@Param("city") City city, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询城市数
	 * @param city
	 * @return
	 */
	public int loadCount(@Param("city") City city);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @param fields
	 * @return
	 */
	public City loadById(@Param("id") long id);
	
	/**
	 * 新增城市
	 * @param city
	 * @return
	 */
	public int insert(@Param("city") City city);
	
	/**
	 * 编辑城市
	 * @param city
	 * @return
	 */
	public int update(@Param("city") City city);
	
	/**
	 * 根据id删除城市
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

	/**
	 * 随机获取城市
	 * 
	 * @return
	 */
	public City loadByRand();

}
