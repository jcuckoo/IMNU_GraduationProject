package cn.com.cyxt.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 菜系实体类
* 
* @author luohaidian
* @date 2018年11月8日
* @time 下午2:48:42
*/
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 菜系名
	 */
	private String name;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 价格
	 */
	private Double price;
	
	/**
	 * 简介
	 */
	private String content;
	
	/**
	 * 浏览次数
	 */
	private Integer hitCount;
	
	/**
	 * 买单次数
	 */
	private Integer buyCount;
	
	/**
	 * 评分
	 */
	private Integer score;
	
	/**
	 * 是否推荐(0-不推荐,1-推荐)
	 */
	private Boolean groom;
	
	/**
	 * 菜系封面
	 */
	private String coverImg;
	
	/**
	 * 所属菜系类别
	 */
	private MenuType menuType;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getHitCount() {
		return hitCount;
	}

	public void setHitCount(Integer hitCount) {
		this.hitCount = hitCount;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getGroom() {
		return groom;
	}

	public void setGroom(Boolean groom) {
		this.groom = groom;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

}
