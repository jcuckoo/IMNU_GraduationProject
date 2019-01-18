package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Company;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:54:47
 */
@Mapper
@Repository
public interface ICompanyMapper {
	
	/**
	 * 查询保险公司列表
	 * @param company
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Company> loads(
			@Param("company") Company company, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询保险公司数
	 * @param company
	 * @return
	 */
	public int loadCount(@Param("company") Company company);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @param fields
	 * @return
	 */
	public Company loadById(@Param("id") long id);
	
	/**
	 * 新增保险公司
	 * @param company
	 * @return
	 */
	public int insert(@Param("company") Company company);
	
	/**
	 * 编辑保险公司
	 * @param company
	 * @return
	 */
	public int update(@Param("company") Company company);
	
	/**
	 * 根据id删除保险公司
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

}
