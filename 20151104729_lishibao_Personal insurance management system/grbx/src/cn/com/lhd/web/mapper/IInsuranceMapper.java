package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Insurance;

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
public interface IInsuranceMapper {
	
	/**
	 * 查询保险信息列表
	 * @param insurance
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Insurance> loads(
			@Param("insurance") Insurance insurance, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询保险信息数
	 * @param insurance
	 * @return
	 */
	public int loadCount(@Param("insurance") Insurance insurance);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @param fields
	 * @return
	 */
	public Insurance loadById(@Param("id") long id);
	
	/**
	 * 新增保险信息
	 * @param insurance
	 * @return
	 */
	public int insert(@Param("insurance") Insurance insurance);
	
	/**
	 * 编辑保险信息
	 * @param insurance
	 * @return
	 */
	public int update(@Param("insurance") Insurance insurance);
	
	/**
	 * 根据id删除保险信息
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long ids);

}
