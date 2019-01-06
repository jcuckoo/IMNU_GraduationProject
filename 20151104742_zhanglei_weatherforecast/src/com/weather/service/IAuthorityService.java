package com.weather.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.Authority;


public interface IAuthorityService {
	
	/**
	 * 查询权限列表
	 * @param authority
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Authority> queryList(Authority authority, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询权限列表数
	 * @param authority
	 * @return
	 */
	public int queryCount(Authority authority);

	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Authority queryById(Long id);

}
