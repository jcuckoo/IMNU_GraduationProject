package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc 角色实体类
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:05:06
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Role() {
		super();
	}
	
	public Role(Long id) {
		super();
		this.id = id;
	}

	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
