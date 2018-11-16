package com.qst.bean;

public class Menu {
	private int menu_id;
	private String menu_name;
	private int menu_price;
	private int menuclass_id;
	
	public Menu() {
		
	}
	public Menu(int menu_id, String menu_name, int menu_price, int menuclass_id) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.menuclass_id = menuclass_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	public int getMenuclass_id() {
		return menuclass_id;
	}
	public void setMenuclass_id(int menuclass_id) {
		this.menuclass_id = menuclass_id;
	}
	

}
