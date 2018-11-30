package com.qst.bean;

public class MenuClass {
	private int menuclass_id;
	private String menuclass_name;
	
	public MenuClass() {
		
	}
	public MenuClass(int menuclass_id, String menuclass_name) {
		super();
		this.menuclass_id = menuclass_id;
		this.menuclass_name = menuclass_name;
	}
	public int getMenuclass_id() {
		return menuclass_id;
	}
	public void setMenuclass_id(int menuclass_id) {
		this.menuclass_id = menuclass_id;
	}
	public String getMenuclass_name() {
		return menuclass_name;
	}
	public void setMenuclass_name(String menuclass_name) {
		this.menuclass_name = menuclass_name;
	}
	
	
	

}
