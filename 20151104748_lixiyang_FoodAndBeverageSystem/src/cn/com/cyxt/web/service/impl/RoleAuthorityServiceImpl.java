package cn.com.cyxt.web.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.mapper.IRoleAuthorityMapper;
import cn.com.cyxt.web.service.IRoleAuthorityService;



/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年10月21日
 * @time 下午10:41:29
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
