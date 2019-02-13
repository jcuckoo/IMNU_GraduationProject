package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Set;

import cn.com.cyxt.web.entity.Authority;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:15
 */
public interface IAuthorityService {
	
	/**
	 * 查询权限列表
	 * @param authority
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Authority> queryList(Authority authority, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询权限列表数
	 * @param authority
	 * @return
	 */
	public int queryCount(Authority authority);

	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Authority queryById(Long id);

}
