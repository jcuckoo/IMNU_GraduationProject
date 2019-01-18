package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc 保险公司实体类
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:53:30
 */
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 公司名称
	 */
	private String name;
	
	/**
	 * 公司编号
	 */
	private String number;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 公司联系方式
	 */
	private String mobile;
	
	/**
	 * 公司地址
	 */
	private String address;
	
	/**
	 * 创始人
	 */
	private String creator;
	
	/**
	 * 公司简介
	 */
	private String remark;

	public Company() {
		super();
	}

	public Company(Long id) {
		super();
		this.id = id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
