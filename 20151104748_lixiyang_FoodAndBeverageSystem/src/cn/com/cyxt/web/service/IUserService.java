package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.cyxt.web.entity.User;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:40:18
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
	public Optional<User> queryByUserName(String username);

	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Optional<User> queryById(Long id);

	/**
	 * 新增/编辑
	 * @param user
	 * @return
	 */
	public boolean saveOrUpdate(User user);

	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	public boolean delete(Set<Long> ids);

}
