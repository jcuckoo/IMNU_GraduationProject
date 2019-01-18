package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc 用户实体类
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:04:54
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
	private String truename;

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
	 * 邮箱地址
	 */
	private String email;
	
	/**
	 * 头像
	 */
	private String picImg;
	
	/**
	 * 住址
	 */
	private String address;
	
	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
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

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicImg() {
		return picImg;
	}

	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
