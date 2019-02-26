package cn.com.lhd.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
*
* @desc 电影实体类
* 
*/
public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键Id
	 */
	private Long id;
	
	/**
	 * 电影标题
	 */
	private String title;
	
	/**
	 * 电影摘要
	 */
	private String summary;
	
	/**
	 * 电影内容
	 */
	private String content;
	
	/**
	 * 上传时间
	 */
	private Date createTime;
	
	/**
	 * 是否推荐
	 */
	private Boolean groom;
	
	/**
	 * 点击次数
	 */
	private Integer clickCount;
	
	/**
	 * 是否是vip电影
	 */
	private Boolean vip;
	
	/**
	 * 评分
	 */
	private Integer score;
	
	/**
	 * 状态(0-未审核，1-已审核)
	 */
	private Integer status;
	
	/**
	 * 电影地址
	 */
	private String videoUrl;
	
	/**
	 * 电影封面
	 */
	private String coverImg;
	
	/**
	 * 所属电影类别
	 */
	private FilmType filmType;
	
	/**
	 * 上传用户
	 */
	private User creator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getGroom() {
		return groom;
	}

	public void setGroom(Boolean groom) {
		this.groom = groom;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public FilmType getFilmType() {
		return filmType;
	}

	public void setFilmType(FilmType filmType) {
		this.filmType = filmType;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
