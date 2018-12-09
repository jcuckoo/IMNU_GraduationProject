package cn.com.lhd.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Friend;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:40:18
 */
public interface IFriendService {
	
	
	/**
	 * 查询好友列表
	 * 
	 * @param friend
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Friend> queryList(Friend friend, Boolean nameLikeMode, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询好友列表数
	 * 
	 * @param friend
	 * @return
	 */
	public int queryCount(Friend friend, Boolean nameLikeMode);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Optional<Friend> queryById(Long id);

	/**
	 * 新增
	 * @param friend
	 * @return
	 */
	public boolean save(Friend friend);

	/**
	 * 删除好友
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
