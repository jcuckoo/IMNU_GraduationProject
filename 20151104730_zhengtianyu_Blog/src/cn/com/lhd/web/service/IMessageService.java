package cn.com.lhd.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Message;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:40:18
 */
public interface IMessageService {
	
	
	/**
	 * 查询留言列表
	 * 
	 * @param message
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Message> queryList(Message message, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询留言列表数
	 * 
	 * @param message
	 * @return
	 */
	public int queryCount(Message message);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Optional<Message> queryById(Long id);

	/**
	 * 新增
	 * @param message
	 * @return
	 */
	public boolean save(Message message);

	/**
	 * 删除留言
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
