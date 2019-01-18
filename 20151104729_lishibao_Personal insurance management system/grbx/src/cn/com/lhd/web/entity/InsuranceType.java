package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @desc 保险类别实体类
 *
 * @author luohaidian
 * @date 2018年12月21日
 * @time 上午9:21:29
 */
public class InsuranceType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * id
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

	public InsuranceType() {
		super();
	}

	public InsuranceType(Long id) {
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

}
