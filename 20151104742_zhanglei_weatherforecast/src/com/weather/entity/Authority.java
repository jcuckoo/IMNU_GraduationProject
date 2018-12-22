package com.weather.entity;

import java.io.Serializable;

import cn.com.lhd.core.model.BaseTree;



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
     * 图标
     */
    private String menuIcon;

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

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

}
