package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.cyxt.web.entity.MenuType;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc 菜系类别接口
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:28
 */
public interface IMenuTypeService {
	
	/**
	 * 菜系类别列表
	 * @param menuType
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<MenuType> queryList(MenuType menuType, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 菜系类别数
	 * @param menuType
	 * @return
	 */	public int queryCount(MenuType menuType);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Optional<MenuType> queryById(Long id);

	/**
	 * 新增/编辑菜系类别信息
	 * @param menuType
	 * @return
	 */
	public boolean saveOrUpdate(MenuType menuType);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);
	
	/**
	 * 菜系类别归档
	 * 
	 * @return
	 */
	public List<MenuType> queryWithMenuCount();
	
}
