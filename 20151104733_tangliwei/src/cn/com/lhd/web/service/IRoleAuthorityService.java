package cn.com.lhd.web.service;

import java.util.Set;

/**
 *
 * @desc 角色-菜单权限Service接口
 *
 */
public interface IRoleAuthorityService {
	
	/**
	 * 根据角色Id查询
	 * 
	 * @param roleId 角色Id
	 * @return
	 */
	public Set<Long> queryByRoleId(Long roleId);

}
