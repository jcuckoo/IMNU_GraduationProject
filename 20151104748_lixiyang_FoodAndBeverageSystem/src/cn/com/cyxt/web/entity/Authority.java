package cn.com.cyxt.web.entity;

import java.io.Serializable;

import cn.com.lhd.core.model.BaseTree;

/**
 * 
 * @desc 权限菜单实体类
 *
 * @author luohaidian
 * @date 2018年11月7日
 * @time 下午8:38:56
 */
public class Authority  extends BaseTree<Long, Authority> implements Serializable {

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
    
    /**
     * 菜单位置，1-前台，2-后台
     */
    private String menuPosition;
    
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

	public String getMenuPosition() {
		return menuPosition;
	}

	public void setMenuPosition(String menuPosition) {
		this.menuPosition = menuPosition;
	}

}
