package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.InsuranceType;

/**
 *
 * @desc 保险类别Service接口
 *
 * @author luohaidian
 * @date 2018年12月21日
 * @time 上午9:47:40
 */
public interface IInsuranceTypeService {
	
	/**
	 * 保险类别列表
	 * 
	 * @param insuranceType
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<InsuranceType> queryList(InsuranceType insuranceType, Set<ISort> sortSet, IPage page);
	
	/**
	 * 保险类别列表数
	 * 
	 * @param insuranceType
	 * @return
	 */
	public int queryCount(InsuranceType insuranceType);

	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public InsuranceType queryById(Long id);

	/**
	 * 保存保险类别
	 * 
	 * @param insuranceType
	 * @return
	 */
	public boolean saveOrUpdate(InsuranceType insuranceType);

	/**
	 * 根据Id删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

}
