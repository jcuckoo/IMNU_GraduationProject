package com.weather.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.Role;


@Mapper
@Repository
public interface IRoleMapper {
	
	/**
	 * 查询角色列表
	 * @param role
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Role> loads(
			@Param("role") Role role, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询角色列表数
	 * @param role
	 * @return
	 */
	public int loadCount(@Param("role") Role role);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Role loadById(@Param("id") long id);
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	public int insert(@Param("role") Role role);
	
	/**
	 * 编辑角色
	 * @param role
	 * @return
	 */
	public int update(@Param("role") Role role);

}
