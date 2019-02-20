package cn.com.cyxt.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.entity.Role;
import cn.com.cyxt.web.mapper.IRoleMapper;
import cn.com.cyxt.web.service.IRoleService;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;


/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:40:49
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
