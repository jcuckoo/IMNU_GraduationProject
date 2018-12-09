package cn.com.lhd.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Role;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:40:11
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
	public Optional<Role> queryById(Long id);

	/**
	 * 新增/编辑
	 * @param role
	 * @return
	 */
	public boolean saveOrUpdate(Role role);

}
