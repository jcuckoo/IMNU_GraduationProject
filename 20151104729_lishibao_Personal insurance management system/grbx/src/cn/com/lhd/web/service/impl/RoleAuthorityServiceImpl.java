package cn.com.lhd.web.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.web.mapper.IRoleAuthorityMapper;
import cn.com.lhd.web.service.IRoleAuthorityService;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午4:39:53
 */
@Service
public class RoleAuthorityServiceImpl implements IRoleAuthorityService {
	
	@Autowired
	private IRoleAuthorityMapper iRoleAuthorityMapper;

	@Override
	public Set<Long> queryByRoleId(Long roleId) {
		return iRoleAuthorityMapper.loadByRoleId(roleId);
	}

}
