package cn.com.cyxt.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.cyxt.web.entity.Stock;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;

/**
 * 
 * @desc 产品库存接口
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:28
 */
public interface IStockService {

	/**
	 * 产品库存列表
	 * 
	 * @param stock
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Stock> queryList(Stock stock, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 产品库存数
	 * 
	 * @param stock
	 * @return
	 */
	public int queryCount(Stock stock);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Stock> queryById(Long id);

	/**
	 * 新增产品库存信息
	 * 
	 * @param stock
	 * @return
	 */
	public boolean saveOrUpdate(Stock stock);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
