package cn.com.cyxt.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 买家菜单明细实体类
* 
* @author luohaidian
* @date 2018年11月9日
* @time 上午10:56:35
*/
public class MenuItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 菜单Id
	 */
	private Long menuId;
	
	/**
	 * 菜单名
	 */
	private String menuName;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户Id
	 */
	private Long userId;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 菜单价格
	 */
	private Double menuPrice;
	
	/**
	 * 状态(0-未付款，1-已付款)
	 */
	private Integer state;
	
	/**
	 * 备注(如用户忌口等信息)
	 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(Double menuPrice) {
		this.menuPrice = menuPrice;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
