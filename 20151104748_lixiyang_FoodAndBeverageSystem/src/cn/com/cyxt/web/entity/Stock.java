package cn.com.cyxt.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 库存实体类
* 
* @author luohaidian
* @date 2018年11月9日
* @time 下午4:46:28
*/
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 产品编号
	 */
	private String productNo;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品库存量
	 */
	private Integer stockNum;
	
	/**
	 * 录入时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
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
	
}
