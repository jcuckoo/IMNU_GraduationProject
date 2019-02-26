package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Authority;

/**
 *
 * @desc 菜单权限Service接口
 *
 */
public interface IAuthorityService {
	
	/**
	 * 查询权限列表
	 * 
	 * @param authority 菜单权限模型
	 * @param fields 查询属性
	 * @param sortSet 排序器
	 * @param page 分页
	 * @return
	 */
	public List<Authority> queryList(Authority authority, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询权限列表数
	 * 
	 * @param authority 菜单权限模型
	 * @return
	 */
	public int queryCount(Authority authority);

	/**
	 * 根据Id查询
	 * 
	 * @param id 菜单权限Id
	 * @return
	 */
	public Authority queryById(Long id);

}
