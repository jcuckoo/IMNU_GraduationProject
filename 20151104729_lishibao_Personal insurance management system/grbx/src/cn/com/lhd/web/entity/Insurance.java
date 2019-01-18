package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc 保险信息实体类
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:53:53
 */
public class Insurance implements Serializable {

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
	 * 保险标题
	 */
	private String title;
	
	/**
	 * 简介
	 */
	private String summary;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 所属保险类别
	 */
	private InsuranceType insuranceType;
	
	/**
	 * 所属公司
	 */
	private Company company;
	
	/**
	 * 保险金额
	 */
	private Float money;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 是否推荐(0-未推荐，1-已推荐)
	 */
	private Boolean groom;
	
	/**
	 * 期限
	 */
	private Integer dueTime;
	
	/**
	 * 封面图
	 */
	private String coverImg;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getGroom() {
		return groom;
	}

	public void setGroom(Boolean groom) {
		this.groom = groom;
	}

	public Integer getDueTime() {
		return dueTime;
	}

	public void setDueTime(Integer dueTime) {
		this.dueTime = dueTime;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	
}
