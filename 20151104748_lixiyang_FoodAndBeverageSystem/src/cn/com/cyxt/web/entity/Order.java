package cn.com.cyxt.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 订单实体类
* 
* @author luohaidian
* @date 2018年11月9日
* @time 下午3:47:10
*/
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 菜单名列表
	 */
	private String menuNames;
	
	/**
	 * 总价
	 */
	private Double price;
	
	/**
	 * 点餐备注信息
	 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMenuNames() {
		return menuNames;
	}

	public void setMenuNames(String menuNames) {
		this.menuNames = menuNames;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
