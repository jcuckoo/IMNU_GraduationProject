package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.cyxt.web.entity.Menu;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc 菜单接口
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:28
 */
public interface IMenuService {

	/**
	 * 菜单列表
	 * 
	 * @param menu
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Menu> queryList(Menu menu, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 菜单数
	 * 
	 * @param menu
	 * @return
	 */
	public int queryCount(Menu menu);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Menu> queryById(Long id);

	/**
	 * 新增/编辑菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	public boolean saveOrUpdate(Menu menu);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
