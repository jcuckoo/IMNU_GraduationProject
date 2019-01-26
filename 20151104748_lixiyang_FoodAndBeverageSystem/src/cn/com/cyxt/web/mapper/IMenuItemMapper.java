package cn.com.cyxt.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.cyxt.web.entity.MenuItem;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月9日
 * @time 上午11:39:29
 */
@Mapper
@Repository
public interface IMenuItemMapper {
	
	/**
	 * 查询菜单明细列表
	 * @param menuItem 菜单明细模型
	 * @param fields 查询属性
	 * @param sortSet 排序
	 * @param page 分页
	 * @return
	 */
	public List<MenuItem> loads(
			@Param("menuItem") MenuItem menuItem, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询菜单明细列表数
	 * @param menuItem
	 * @return
	 */
	public int loadCount(@Param("menuItem") MenuItem menuItem);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public MenuItem loadById(@Param("id") Long id);
	
	/**
	 * 新增菜单明细
	 * @param menuItem
	 * @return
	 */
	public int insert(@Param("menuItem") MenuItem menuItem);
	
	/**
	 * 编辑菜单明细
	 * @param menuItem
	 * @return
	 */
	public int update(@Param("menuItem") MenuItem menuItem);

	/**
	 * 根据id删除菜单明细
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

}
