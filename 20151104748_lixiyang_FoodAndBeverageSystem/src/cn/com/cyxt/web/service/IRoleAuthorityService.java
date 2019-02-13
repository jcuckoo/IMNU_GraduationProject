package cn.com.cyxt.web.service;

import java.util.Set;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年10月21日
 * @time 下午10:37:59
 */
public interface IRoleAuthorityService {
	
	/**
	 * 根据角色Id查询
	 * @param roleId
	 * @return
	 */
	public Set<Long> queryByRoleId(Long roleId);

}
