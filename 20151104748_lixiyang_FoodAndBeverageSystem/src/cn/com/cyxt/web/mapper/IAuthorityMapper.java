package cn.com.cyxt.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.cyxt.web.entity.Authority;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;


/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月7日
 * @time 下午9:22:51
 */
@Mapper
@Repository
public interface IAuthorityMapper {
	
	/**
	 * 查询权限列表
	 * 
	 * @param authority
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return List
	 */
	public List<Authority> loads(
			@Param("authority") Authority authority, 
			@Param("fields") Set<String> fields, 
			@Param("sorts") Set<ISort> sortSet, 
			@Param("page") IPage page);
	
	/**
	 * 查询权限数
	 * 
	 * @param authority
	 * @return int
	 */
	public int loadCount(@Param("authority") Authority authority);

	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Authority loadById(@Param("id") Long id);
	
}
