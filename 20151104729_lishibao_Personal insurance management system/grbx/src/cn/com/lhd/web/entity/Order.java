package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc 保单信息实体类
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:53:53
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 保险编号
	 */
	private String number;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 关联投保人
	 */
	private User user;
	
	/**
	 * 投保人姓名
	 */
	private String userName;
	
	/**
	 * 投保金额
	 */
	private Float money;
	
	/**
	 * 开始时间
	 */
	private Date beginTime;
	
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	/**
	 * 保险状态(0-未审批，1-已审批)
	 */
	private Integer state;
	
	/**
	 * 关联保险
	 */
	private Insurance insurance;
	
	/**
	 * 保险名称
	 */
	private String insuranceName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

}
