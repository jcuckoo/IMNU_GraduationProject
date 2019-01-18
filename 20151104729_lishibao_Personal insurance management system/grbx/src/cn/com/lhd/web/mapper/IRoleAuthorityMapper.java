package cn.com.lhd.web.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午4:36:13
 */
@Mapper
@Repository
public interface IRoleAuthorityMapper {
	
	/**
	 * 根据角色Id查询
	 * @param roleId
	 * @return
	 */
	public Set<Long> loadByRoleId(@Param("roleId") Long roleId);

}
