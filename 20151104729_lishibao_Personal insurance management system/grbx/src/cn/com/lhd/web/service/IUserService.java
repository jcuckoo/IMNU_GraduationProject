package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.User;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:12:25
 */
public interface IUserService {
	
	
	/**
	 * 查询用户列表
	 * 
	 * @param user
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<User> queryList(User user, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询用户列表数
	 * 
	 * @param user
	 * @return
	 */
	public int queryCount(User user);
	
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User queryByUserName(String username);

	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public User queryById(Long id);

	/**
	 * 新增/编辑
	 * 
	 * @param user 用户模型
	 * @return
	 */
	public boolean saveOrUpdate(User user);

	/**
	 * 根据Id删除用户
	 * 
	 * @param id 用户Id
	 * @return
	 */
	public boolean delete(Long id);

}
