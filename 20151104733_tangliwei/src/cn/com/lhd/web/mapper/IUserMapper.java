package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.User;

/**
 *
 * @desc 用户Mapper接口
 *
 */
@Mapper
@Repository
public interface IUserMapper {
	
	/**
	 * 查询用户列表
	 * 
	 * @param user 用户模型
	 * @param fields 查询属性
	 * @param sortSet 排序器
	 * @param page 分页
	 * @return
	 */
	public List<User> loads(
			@Param("user") User user, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询用户数
	 * 
	 * @param user 用户模型
	 * @return
	 */
	public int loadCount(@Param("user") User user);
	
	/**
	 * 根据Id查询
	 * 
	 * @param id 用户Id
	 * @param fields 查询属性
	 * @return
	 */
	public User loadById(@Param("id") long id);
	
	/**
	 * 新增用户
	 * 
	 * @param user 用户模型
	 * @return
	 */
	public int insert(@Param("user") User user);
	
	/**
	 * 编辑用户
	 * 
	 * @param user 用户模型
	 * @return
	 */
	public int update(@Param("user") User user);
	
	/**
	 * 根据id删除用户
	 * 
	 * @param id 用户Id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

}
