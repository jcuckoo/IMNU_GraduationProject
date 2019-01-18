package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Company;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:55:31
 */
public interface ICompanyService {
	
	
	/**
	 * 查询保险公司列表
	 * 
	 * @param company
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Company> queryList(Company company, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询保险公司列表数
	 * 
	 * @param company
	 * @return
	 */
	public int queryCount(Company company);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Company queryById(Long id);

	/**
	 * 新增/编辑
	 * @param company
	 * @return
	 */
	public boolean saveOrUpdate(Company company);

	/**
	 * 删除保险公司
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
