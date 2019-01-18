package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.InsuranceType;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月21日
 * @time 上午9:23:27
 */
@Mapper
@Repository
public interface IInsuranceTypeMapper {
	
	/**
	 * 根据Id查询
	 * 
	 * @param id 保险类型Id
	 * @return
	 */
	public InsuranceType loadById(@Param("id") Long id);
	
	/**
	 * 查询保险类别列表
	 * 
	 * @param insuranceType
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<InsuranceType> loads(
			@Param("insuranceType") InsuranceType insuranceType, 
			@Param("sorts")Set<ISort> sortSet,
			@Param("page") IPage page);

	/**
	 * 查询保险类别数
	 * 
	 * @param insuranceType
	 * @return
	 */
	public int loadCount(@Param("insuranceType") InsuranceType insuranceType);

	/**
	 * 新增
	 * 
	 * @param insuranceType
	 * @return
	 */
	public int insert(@Param("insuranceType") InsuranceType insuranceType);

	/**
	 * 编辑
	 * 
	 * @param insuranceType
	 * @return
	 */
	public int update(@Param("insuranceType") InsuranceType insuranceType);

	/**
	 * 根据Id删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(@Param("id") Long id);
	
}
