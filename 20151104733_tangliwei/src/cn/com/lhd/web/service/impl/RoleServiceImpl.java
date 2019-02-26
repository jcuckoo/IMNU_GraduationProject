package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Role;
import cn.com.lhd.web.mapper.IRoleMapper;
import cn.com.lhd.web.service.IRoleService;

/**
 * 
 * @desc
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleMapper iRoleMapper;

	@Override
	public List<Role> queryList(Role role, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iRoleMapper.loads(role, fields, sortSet, page);
	}

	@Override
	public Role queryById(Long id) {
		return iRoleMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(Role role) {
		if (Objects.isNull(role.getId())) {
			return iRoleMapper.insert(role) > 0;
		}
		return iRoleMapper.update(role) > 0;
	}

}
