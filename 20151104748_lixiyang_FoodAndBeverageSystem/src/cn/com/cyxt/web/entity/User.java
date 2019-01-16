package cn.com.cyxt.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc 用户实体类
 *
 * @author luohaidian
 * @date 2018年11月7日
 * @time 下午8:33:01
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码(MD5加密)
	 */
	private String password;

	/**
	 * 真实名
	 */
	private String name;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 电话号码
	 */
	private String mobile;

	/**
	 * 用户所属角色
	 */
	private Role userRole;
	
	/**
	 * 用户类型(C-普通用户，M-管理员)
	 */
	private String userType;

	public User() {
		super();
	}

	public User(String username, String name, String mobile) {
		super();
		this.username = username;
		this.name = name;
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
