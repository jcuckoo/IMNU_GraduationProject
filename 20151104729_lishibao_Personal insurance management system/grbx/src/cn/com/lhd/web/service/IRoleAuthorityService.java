package cn.com.lhd.web.service;

import java.util.Set;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午4:38:33
 */
public interface IRoleAuthorityService {
	
	/**
	 * 根据角色Id查询
	 * @param roleId
	 * @return
	 */
	public Set<Long> queryByRoleId(Long roleId);

}
