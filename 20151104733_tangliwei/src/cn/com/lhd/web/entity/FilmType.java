package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 电影类别实体类
* 
*/
public class FilmType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键Id
	 */
	private Long id;
	
	/**
	 * 电影类别名称
	 */
	private String name;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 对应类别下的影片数
	 */
	private Integer filmCount;
	
	/**
	 * 电影类别说明
	 */
	private String remark;

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

	public Integer getFilmCount() {
		return filmCount;
	}

	public void setFilmCount(Integer filmCount) {
		this.filmCount = filmCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
