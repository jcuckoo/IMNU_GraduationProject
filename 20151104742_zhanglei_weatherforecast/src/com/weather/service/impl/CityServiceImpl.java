package com.weather.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.City;
import com.weather.mapper.ICityMapper;
import com.weather.service.ICityService;


@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private ICityMapper iCityMapper;

	@Override
	public City queryById(Long id) {
		return iCityMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(City city) {
		if (Objects.isNull(city.getId())) {
			return iCityMapper.insert(city) > 0;
		}
		return iCityMapper.update(city) > 0;
	}

	@Override
	public int queryCount(City city) {
		return iCityMapper.loadCount(city);
	}

	@Override
	public List<City> queryList(City city, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iCityMapper.loads(city, fields, sortSet, page);
	}

	@Override
	public boolean delete(Long id) {
		return iCityMapper.delete(id);
	}

	@Override
	public City queryByRand() {
		return iCityMapper.loadByRand();
	}

}
