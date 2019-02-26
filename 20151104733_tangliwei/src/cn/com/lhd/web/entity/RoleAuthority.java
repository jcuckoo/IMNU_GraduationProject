package cn.com.lhd.web.entity;

import java.io.Serializable;

/**
 *
 * @desc 角色-权限实体类
 *
 */
public class RoleAuthority implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 角色Id
	 */
	private Long roleId;
	
	/**
	 * 权限Id
	 */
	private Long authorityId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

}
