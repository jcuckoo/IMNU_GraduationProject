package com.qst.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qst.bean.Menu;
import com.qst.bean.ShopCar;
import com.qst.service.SelectMenuService;
import com.qst.service.SelectShopCarService;



@Controller
public class SelectMenuController {
	
	@Autowired
	private SelectMenuService selectMenuService;
	
	@Autowired
	private SelectShopCarService selectShopCarService;
	
	
	@RequestMapping(value="/Menu")
	public String MenuList(Menu menuInfo,Model model) {
		
		List<Menu> menuList = selectMenuService.select(menuInfo);
		
		model.addAttribute("menuList",menuList);
		return "foodList";
		//后台显示
	}
	
	@RequestMapping(value="/Menu1")
	public String MenuList1(Menu menuInfo,HttpSession session,Model model) {
		
		List<Menu> menuList1 = selectMenuService.select(menuInfo);
		
		model.addAttribute("menuList1",menuList1);
		
		
		/*ShopCar s =new ShopCar();
		s.setUser_id(Integer.parseInt(session.getAttribute("user_id").toString()));
	  List<ShopCar> shopcarList1 = selectShopCarService.select(s);
		
		model.addAttribute("shopcarList1",shopcarList1);
*/
		
		
		return "caipinbiao";
		//前台显示
		
	}
	@RequestMapping(value="/selectMenu",method=RequestMethod.POST)
	public String SelectUser(String keyword,Model model,Menu menuInfo) {
		menuInfo.setMenu_name(keyword);
		List<Menu> menuList = selectMenuService.selectMenu(menuInfo);
		
		model.addAttribute("menuList", menuList);
		//request.setAttribute("menuList", menuList);
		return "foodList";	
//		后台查询
	}

	
	@RequestMapping(value="/selectMenu1",method=RequestMethod.POST)
	public String SelectUser2(String keyword,Model model,Menu menuInfo) {
		menuInfo.setMenu_name(keyword);
		List<Menu> menuList1 = selectMenuService.selectMenu(menuInfo);
		
		model.addAttribute("menuList1", menuList1);
		//request.setAttribute("menuList1", menuList);
		return "caipinbiao";	
//		前台查询
	}

}
