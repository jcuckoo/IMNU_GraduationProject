package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Role;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月9日
 * @time 下午10:22:14
 */
public interface IRoleService {
	
	/**
	 * 查询角色列表
	 * @param role
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Role> queryList(Role role, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Role queryById(Long id);

}
