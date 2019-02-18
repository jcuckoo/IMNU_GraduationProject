package com.weather.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.Weather;


@Mapper
@Repository
public interface IWeatherMapper {
	
	/**
	 * 查询天气列表
	 * @param weather
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Weather> loads(
			@Param("weather") Weather weather,
			@Param("nameLikeModel") Boolean nameLikeModel,
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询天气数
	 * @param weather
	 * @return
	 */
	public int loadCount(@Param("weather") Weather weather, @Param("nameLikeModel") Boolean nameLikeModel);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @param fields
	 * @return
	 */
	public Weather loadById(@Param("id") long id);
	
	/**
	 * 新增天气
	 * @param weather
	 * @return
	 */
	public int insert(@Param("weather") Weather weather);
	
	/**
	 * 根据id删除天气
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

	/**
	 * 情况所有数据
	 * 
	 * @return
	 */
	public boolean deleteAll();

}
