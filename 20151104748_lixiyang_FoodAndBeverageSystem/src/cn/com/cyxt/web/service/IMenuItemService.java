package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.cyxt.web.entity.MenuItem;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc 菜单明细明细接口
 *
 * @author luohaidian
 * @date 2018年11月9日
 * @time 下午8:39:28
 */
public interface IMenuItemService {

	/**
	 * 菜单明细列表
	 * 
	 * @param menuItem
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<MenuItem> queryList(MenuItem menuItem, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 菜单明细数
	 * 
	 * @param menuItem
	 * @return
	 */
	public int queryCount(MenuItem menuItem);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Optional<MenuItem> queryById(Long id);

	/**
	 * 新增/编辑菜单明细信息
	 * 
	 * @param menuItem
	 * @return
	 */
	public boolean saveOrUpdate(MenuItem menuItem);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
