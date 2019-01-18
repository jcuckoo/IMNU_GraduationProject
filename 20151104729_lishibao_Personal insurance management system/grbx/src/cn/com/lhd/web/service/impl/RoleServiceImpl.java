package cn.com.lhd.web.service.impl;

import java.util.List;
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
 * @author luohaidian
 * @date 2018年11月9日
 * @time 下午10:22:39
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

}
