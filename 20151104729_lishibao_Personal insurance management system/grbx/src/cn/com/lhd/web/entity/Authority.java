package cn.com.lhd.web.entity;

import java.io.Serializable;

import cn.com.lhd.core.model.BaseTree;

/**
 *
 * @desc 权限菜单实体类
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午4:34:29
 */
public class Authority  extends BaseTree<String, Authority> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 权限名称
     */
    private String name;

    /**
     * 序号
     */
    private Integer serialNumber;

    /**
     * 权限菜单请求路径
     */
    private String menuHref;

    /**
     * 权限菜单LOGO
     */
    private String menuImg;

    /**
     * 权限菜单类型，1-菜单项，2-功能项
     */
    private String menuType;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

}
