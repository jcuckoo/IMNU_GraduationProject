package com.qst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.bean.MenuClass;
import com.qst.service.SelectMenuClassService;

@Controller
public class SelectMenuClassController {
	
	@Autowired
	private SelectMenuClassService selectMenuClassService;
	
	@RequestMapping(value="/MenuClass")
	public String MenuClassList(MenuClass menuclassInfo,Model model) {
		List<MenuClass> menuclassList  = selectMenuClassService.select(menuclassInfo);
		
		model.addAttribute("menuclassList",menuclassList);
		return "cuisineList";
	}
	@RequestMapping(value="/MenuClass1")
	public String MenuClassList1(MenuClass menuclassInfo,Model model) {
		List<MenuClass> menuclassList1  = selectMenuClassService.select(menuclassInfo);
		
		model.addAttribute("menuclassList1",menuclassList1);
		return "caixibiao";
	}
	
		
	

}
