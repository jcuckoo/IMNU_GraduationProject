package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Order;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:55:40
 */
public interface IOrderService {
	
	
	/**
	 * 查询保单列表
	 * 
	 * @param order
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Order> queryList(Order order, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询保单列表数
	 * 
	 * @param order
	 * @return
	 */
	public int queryCount(Order order);
	
	/**
	 * 根据Id查询
	 * @param orderId
	 * @return
	 */
	public Order queryById(Long id);

	/**
	 * 新增/编辑
	 * @param order
	 * @return
	 */
	public boolean saveOrUpdate(Order order);

	/**
	 * 删除保单
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
