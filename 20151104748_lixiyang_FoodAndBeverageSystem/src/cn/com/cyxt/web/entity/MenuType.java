package cn.com.cyxt.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 菜单类别实体类
* 
* @author luohaidian
* @date 2018年11月8日
* @time 下午2:46:41
*/
public class MenuType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
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
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 该类别对应菜系数
	 */
	private Integer menuCount;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getMenuCount() {
		return menuCount;
	}

	public void setMenuCount(Integer menuCount) {
		this.menuCount = menuCount;
	}

}
