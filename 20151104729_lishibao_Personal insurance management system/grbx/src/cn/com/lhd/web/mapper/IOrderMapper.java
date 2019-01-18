package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Order;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:54:54
 */
@Mapper
@Repository
public interface IOrderMapper {
	
	/**
	 * 查询保单信息列表
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
	 * 查询保单信息数
	 * @param order
	 * @return
	 */
	public int loadCount(@Param("order") Order order);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @param fields
	 * @return
	 */
	public Order loadById(@Param("id") long id);
	
	/**
	 * 新增保单信息
	 * @param order
	 * @return
	 */
	public int insert(@Param("order") Order order);
	
	/**
	 * 编辑保单信息
	 * @param order
	 * @return
	 */
	public int update(@Param("order") Order order);
	
	/**
	 * 根据id删除保单信息
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long ids);

}
