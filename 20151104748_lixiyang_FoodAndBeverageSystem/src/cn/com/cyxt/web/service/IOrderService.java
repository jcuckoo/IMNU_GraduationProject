package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.cyxt.web.entity.Order;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc 订单接口
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:28
 */
public interface IOrderService {

	/**
	 * 订单列表
	 * 
	 * @param order
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Order> queryList(Order order, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 订单数
	 * 
	 * @param order
	 * @return
	 */
	public int queryCount(Order order);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Order> queryById(Long id);

	/**
	 * 新增订单信息
	 * 
	 * @param order
	 * @return
	 */
	public boolean save(Order order);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
