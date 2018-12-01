package com.qst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.bean.MenuClass;
import com.qst.service.DeleteMenuClassService;

@Controller
public class DeleteMenuClassController {
	
	@Autowired
	private DeleteMenuClassService deleteMenuClassService;
	
	@RequestMapping(value="/DeleteMenuClass")
	public String Delete(int id,MenuClass menuclassInfo){
		menuclassInfo.setMenuclass_id(id);
		if(deleteMenuClassService.Delete(menuclassInfo)==1)
			return "redirect:MenuClass";
		else
			return "redirect:MenuClass";
	}

}
