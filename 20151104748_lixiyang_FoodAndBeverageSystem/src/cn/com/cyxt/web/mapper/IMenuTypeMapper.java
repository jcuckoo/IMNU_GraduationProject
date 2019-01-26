package cn.com.cyxt.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.cyxt.web.entity.MenuType;
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
public interface IMenuTypeMapper {

	/**
	 * 查询菜单类别列表
	 * 
	 * @param menuType
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<MenuType> loads(@Param("menuType") MenuType menuType, @Param("fields") Set<String> fields,
			@Param("sorts") Set<ISort> sortSet, @Param("page") IPage page);

	/**
	 * 查询菜单类别列表数
	 * 
	 * @param menuType
	 * @return
	 */
	public int loadCount(@Param("menuType") MenuType menuType);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public MenuType loadById(@Param("id") Long id);

	/**
	 * 新增菜单类别
	 * 
	 * @param menuType
	 * @return
	 */
	public int insert(@Param("menuType") MenuType menuType);

	/**
	 * 编辑菜单类别
	 * 
	 * @param menuType
	 * @return
	 */
	public int update(@Param("menuType") MenuType menuType);

	/**
	 * 根据id删除菜单类别
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

	/**
	 * 菜系类别归档
	 * 
	 * @return
	 */
	public List<MenuType> loadWithMenuCount();

}
