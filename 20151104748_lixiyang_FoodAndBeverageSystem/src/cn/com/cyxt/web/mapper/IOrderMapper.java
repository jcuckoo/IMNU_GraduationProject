package cn.com.cyxt.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.cyxt.web.entity.Order;
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
public interface IOrderMapper {
	
	/**
	 * 查询订单列表
	 * @param order
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Order> loads(
			@Param("order") Order order, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询订单列表数
	 * @param order
	 * @return
	 */
	public int loadCount(@Param("order") Order order);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Order loadById(@Param("id") Long id);
	
	/**
	 * 新增订单
	 * @param order
	 * @return
	 */
	public int insert(@Param("order") Order order);
	
	/**
	 * 根据id删除订单
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

}
