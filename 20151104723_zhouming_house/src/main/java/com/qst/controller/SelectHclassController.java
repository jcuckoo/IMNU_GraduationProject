package com.qst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.bean.Hclass;
import com.qst.service.SelectHclassService;



@Controller
public class SelectHclassController {
	
	@Autowired
	private SelectHclassService selectHclassService;
	
	@RequestMapping(value="/Type")
	public String HclassList(Hclass hclassInfo,Model model) {
		List<Hclass> hclassList  = selectHclassService.select(hclassInfo);
		
		model.addAttribute("hclassList",hclassList);
		return "housetypeList";
	}//后台房屋类型查看
	/*@RequestMapping(value="/")
	public String MenuClassList1(Hclass hclassInfo,Model model) {
		List<Hclass> hclassList1  = selectHclassService.select(hclassInfo);
		
		model.addAttribute("",hclassList1);
		return "";
	}//前台房屋类型查看
*/	
		
	

}
