package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Insurance;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:55:40
 */
public interface IInsuranceService {
	
	
	/**
	 * 查询保险列表
	 * 
	 * @param insurance
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Insurance> queryList(Insurance insurance, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询保险列表数
	 * 
	 * @param insurance
	 * @return
	 */
	public int queryCount(Insurance insurance);
	
	/**
	 * 根据Id查询
	 * @param insuranceId
	 * @return
	 */
	public Insurance queryById(Long id);

	/**
	 * 新增/编辑
	 * @param insurance
	 * @return
	 */
	public boolean saveOrUpdate(Insurance insurance);

	/**
	 * 删除保险
	 * @param id
	 * @return
	 */
	public boolean delete(Long ids);

}
