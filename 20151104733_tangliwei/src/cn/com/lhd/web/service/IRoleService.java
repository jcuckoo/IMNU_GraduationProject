package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Role;

/**
 * 
 * @desc 角色Service接口
 *
 */
public interface IRoleService {
	
	/**
	 * 查询角色列表
	 * 
	 * @param role 角色模型
	 * @param fields 查询属性
	 * @param sortSet 排序器
	 * @param page 分页
	 * @return
	 */
	public List<Role> queryList(Role role, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 根据Id查询
	 * 
	 * @param id 角色Id
	 * @return
	 */
	public Role queryById(Long id);

	/**
	 * 新增/编辑
	 * 
	 * @param role 角色模型
	 * @return
	 */
	public boolean saveOrUpdate(Role role);

}
