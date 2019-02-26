package cn.com.lhd.web.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @desc
 *
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
