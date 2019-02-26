package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Role;

/**
 * 
 * @desc 角色Mapper接口
 *
 */
@Mapper
@Repository
public interface IRoleMapper {
	
	/**
	 * 查询角色列表
	 * 
	 * @param role 角色模型
	 * @param fields 查询属性
	 * @param sortSet 排序器
	 * @param page 分页
	 * @return
	 */
	public List<Role> loads(
			@Param("role") Role role, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询角色列表数
	 * 
	 * @param role 角色模型
	 * @return
	 */
	public int loadCount(@Param("role") Role role);
	
	/**
	 * 根据Id查询
	 * 
	 * @param id 角色Id
	 * @return
	 */
	public Role loadById(@Param("id") long id);
	
	/**
	 * 新增角色
	 * 
	 * @param role 角色模型
	 * @return
	 */
	public int insert(@Param("role") Role role);
	
	/**
	 * 编辑角色
	 * 
	 * @param role 角色模型
	 * @return
	 */
	public int update(@Param("role") Role role);

}
