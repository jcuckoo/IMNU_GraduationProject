package com.weather.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.Weather;
import com.weather.mapper.IWeatherMapper;
import com.weather.service.IWeatherService;


@Service
public class WeatherServiceImpl implements IWeatherService {
	
	@Autowired
	private IWeatherMapper iWeatherMapper;

	@Override
	public Weather queryById(Long id) {
		return iWeatherMapper.loadById(id);
	}

	@Override
	public boolean save(Weather weather) {
		return iWeatherMapper.insert(weather) > 0;
	}

	@Override
	public int queryCount(Weather weather, Boolean nameLikeModel) {
		return iWeatherMapper.loadCount(weather, nameLikeModel);
	}

	@Override
	public List<Weather> queryList(Weather weather, Boolean nameLikeModel, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iWeatherMapper.loads(weather, nameLikeModel, fields, sortSet, page);
	}

	@Override
	public boolean delete(Long id) {
		return iWeatherMapper.delete(id);
	}

	@Override
	public boolean deleteAll() {
		return iWeatherMapper.deleteAll();
	}

}
