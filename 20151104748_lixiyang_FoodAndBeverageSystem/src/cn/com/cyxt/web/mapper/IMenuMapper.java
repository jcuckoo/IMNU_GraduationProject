package cn.com.cyxt.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.cyxt.web.entity.Menu;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月8日
 * @time 下午3:03:48
 */
@Mapper
@Repository
public interface IMenuMapper {
	
	/**
	 * 查询菜单列表
	 * @param menu
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Menu> loads(
			@Param("menu") Menu menu, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询菜单列表数
	 * @param menu
	 * @return
	 */
	public int loadCount(@Param("menu") Menu menu);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Menu loadById(@Param("id") Long id);
	
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	public int insert(@Param("menu") Menu menu);
	
	/**
	 * 编辑菜单
	 * @param menu
	 * @return
	 */
	public int update(@Param("menu") Menu menu);

	/**
	 * 根据id删除菜单
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

}
