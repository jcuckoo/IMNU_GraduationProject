package cn.com.cyxt.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.cyxt.web.entity.Stock;
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
public interface IStockMapper {
	
	/**
	 * 查询产品库存量列表
	 * @param stock
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Stock> loads(
			@Param("stock") Stock stock, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询产品库存量列表数
	 * @param stock
	 * @return
	 */
	public int loadCount(@Param("stock") Stock stock);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Stock loadById(@Param("id") Long id);
	
	/**
	 * 新增产品库存量
	 * @param stock
	 * @return
	 */
	public int insert(@Param("stock") Stock stock);
	
	/**
	 * 更新产品库存量
	 * @param stock
	 * @return
	 */
	public int update(@Param("stock") Stock stock);
	
	/**
	 * 根据id删除产品库存量
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

}
