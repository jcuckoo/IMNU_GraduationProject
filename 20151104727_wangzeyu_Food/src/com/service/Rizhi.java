package com.service;

import java.util.Date;

public class Rizhi {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_rizhi.rizhiId
	 * @mbggenerated
	 */
	private Integer rizhiId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_rizhi.rizhiName
	 * @mbggenerated
	 */
	private String rizhiName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_rizhi.dengluIp
	 * @mbggenerated
	 */
	private String dengluIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_rizhi.date
	 * @mbggenerated
	 */
	private Date date;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_rizhi.rizhiId
	 * @return  the value of t_rizhi.rizhiId
	 * @mbggenerated
	 */
	public Integer getRizhiId() {
		return rizhiId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_rizhi.rizhiId
	 * @param rizhiId  the value for t_rizhi.rizhiId
	 * @mbggenerated
	 */
	public void setRizhiId(Integer rizhiId) {
		this.rizhiId = rizhiId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_rizhi.rizhiName
	 * @return  the value of t_rizhi.rizhiName
	 * @mbggenerated
	 */
	public String getRizhiName() {
		return rizhiName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_rizhi.rizhiName
	 * @param rizhiName  the value for t_rizhi.rizhiName
	 * @mbggenerated
	 */
	public void setRizhiName(String rizhiName) {
		this.rizhiName = rizhiName == null ? null : rizhiName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_rizhi.dengluIp
	 * @return  the value of t_rizhi.dengluIp
	 * @mbggenerated
	 */
	public String getDengluIp() {
		return dengluIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_rizhi.dengluIp
	 * @param dengluIp  the value for t_rizhi.dengluIp
	 * @mbggenerated
	 */
	public void setDengluIp(String dengluIp) {
		this.dengluIp = dengluIp == null ? null : dengluIp.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_rizhi.date
	 * @return  the value of t_rizhi.date
	 * @mbggenerated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_rizhi.date
	 * @param date  the value for t_rizhi.date
	 * @mbggenerated
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}