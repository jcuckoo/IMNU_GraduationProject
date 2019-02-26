package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.User;

/**
 *
 * @desc 用户Service接口
 *
 */
public interface IUserService {
	
	
	/**
	 * 查询用户列表
	 * 
	 * @param user 用户模型
	 * @param fields 查询属性
	 * @param sortSet 排序器
	 * @param page 分页
	 * @return
	 */
	public List<User> queryList(User user, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询用户列表数
	 * 
	 * @param user 用户模型
	 * @return
	 */
	public int queryCount(User user);
	
	/**
	 * 根据用户名查询用户
	 * 
	 * @param username 用户名
	 * @return
	 */
	public User queryByUserName(String username);

	/**
	 * 根据Id查询
	 * 
	 * @param id 用户Id
	 * @return
	 */
	public User queryById(Long id);

	/**
	 * 新增/编辑
	 * @param user
	 * @return
	 */
	public boolean saveOrUpdate(User user);

	/**
	 * 删除用户
	 * 
	 * @param id 用户Id
	 * @return
	 */
	public boolean delete(Long id);

}
