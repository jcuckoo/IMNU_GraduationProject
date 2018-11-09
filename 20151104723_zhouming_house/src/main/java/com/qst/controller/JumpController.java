package com.qst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	@RequestMapping("/index")
	public String index(){
	return "index";
	}
	
	@RequestMapping("/loginandregister")
	public String loginandregister(){
	return "loginandregister";
	}
	
	@RequestMapping("/top")
	public String top(){
	return "top";
	}
	
	@RequestMapping("/left")
	public String left(){
	return "left";
	}
	
	@RequestMapping("/right")
	public String right(){
	return "right";
	}
	
	@RequestMapping("/bottom")
	public String bottom(){
	return "bottom";
	}
	
	@RequestMapping("/yonghuList")
	public String yonghuList(){
	return "yonghuList";
	}
	
	@RequestMapping("/housetypeList")
	public String housetypeList(){
	return "housetypeList";
	}
	
	@RequestMapping("/houseList")
	public String houseList(){
	return "houseList";
	}
	
	@RequestMapping("/orderList")
	public String orderList(){
	return "orderList";
	}
	
	
}
