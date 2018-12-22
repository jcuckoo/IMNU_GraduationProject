package com.weather.entity;

import java.io.Serializable;
import java.util.Date;

/**
天气实体类
**/
public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 城市名
	 */
	private String cityName;
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 最高温度
	 */
	private Integer tmpMax;
	
	/**
	 * 最低温度
	 */
	private Integer tmpMin;
	
	/**
	 * 白天天气状况描述
	 */
	private String condTxtD;
	
	/**
	 * 晚上天气状况描述
	 */
	private String condTxtN;
	
	/**
	 * 风向
	 */
	private String windDir;
	
	/**
	 * 风力
	 */
	private String windSc;
	
	/**
	 * 相对湿度
	 */
	private String hum;
	
	/**
	 * 降水量
	 */
	private String pcpn;
	
	/**
	 * 可见度
	 */
	private String vis;
	
	/**
	 * 天气状态(0-晴，1-雨，2-雪，3-雷电)
	 */
	private Integer state;
	
	/**
	 * 生成时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTmpMax() {
		return tmpMax;
	}

	public void setTmpMax(Integer tmpMax) {
		this.tmpMax = tmpMax;
	}

	public Integer getTmpMin() {
		return tmpMin;
	}

	public void setTmpMin(Integer tmpMin) {
		this.tmpMin = tmpMin;
	}

	public String getCondTxtD() {
		return condTxtD;
	}

	public void setCondTxtD(String condTxtD) {
		this.condTxtD = condTxtD;
	}

	public String getCondTxtN() {
		return condTxtN;
	}

	public void setCondTxtN(String condTxtN) {
		this.condTxtN = condTxtN;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	public String getWindSc() {
		return windSc;
	}

	public void setWindSc(String windSc) {
		this.windSc = windSc;
	}

	public String getHum() {
		return hum;
	}

	public void setHum(String hum) {
		this.hum = hum;
	}

	public String getPcpn() {
		return pcpn;
	}

	public void setPcpn(String pcpn) {
		this.pcpn = pcpn;
	}

	public String getVis() {
		return vis;
	}

	public void setVis(String vis) {
		this.vis = vis;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
