package com.weather.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import com.weather.entity.Role;
import com.weather.mapper.IRoleMapper;
import com.weather.service.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleMapper iRoleMapper;

	@Override
	public List<Role> queryList(Role role, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iRoleMapper.loads(role, fields, sortSet, page);
	}

	@Override
	public Optional<Role> queryById(Long id) {
		Role role = iRoleMapper.loadById(id);
		return Optional.ofNullable(role);
	}

	@Override
	public boolean saveOrUpdate(Role role) {
		if (Objects.isNull(role.getId())) {
			return iRoleMapper.insert(role) > 0;
		}
		return iRoleMapper.update(role) > 0;
	}

}
