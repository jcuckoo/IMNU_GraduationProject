package com.qst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

	@RequestMapping("/houtaishouye")
	public String houtaishouye(){
	return "houtaishouye";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/top")
	public String top(){
		return "top";
	}
	
	@RequestMapping("/left")
	public String left(){
		return "left";
	}
	
	@RequestMapping("/bottom")
	public String bottom(){
		return "bottom";
	}
	
	@RequestMapping("/cuisineList")
	public String cuisineList(){
		return "cuisineList";
	}
	
	@RequestMapping("/foodList")
	public String foodList(){
		return "foodList";
	}
	
	@RequestMapping("/gonggao")
	public String gonggao(){
		return "gonggao";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/orderDetail")
	public String orderDetail(){
		return "orderDetail";
	}
	
	@RequestMapping("/orderList")
	public String orderList(){
		return "orderList";
	}
	
	@RequestMapping("/right")
	public String right(){
		return "right";
	}
	
	@RequestMapping("/saveBoard")
	public String saveBoard(){
		return "saveBoard";
	}
	
	@RequestMapping("/saveCuisine")
	public String saveCuisine(){
		return "saveCuisine";
	}
	
	@RequestMapping("/saveFood")
	public String saveFood(){
		return "saveFood";
	}
	
	@RequestMapping("/updateCuisine")
	public String updateCuisine(){
		return "updateCuisine";
	}
	
	@RequestMapping("/updateFood")
	public String updateFood(){
		return "updateFood";
	}
	
	@RequestMapping("/yonghuList")
	public String yonghuList(){
		return "yonghuList";
	}
	
	@RequestMapping("/anquanguan")
	public String anquanguan(){
		return "anquanguan";
	}
	
	@RequestMapping("/caipinxiangqing")
	public String caipinxiangqing(){
		return "caipinxiangqing";
	}
	@RequestMapping("/chuancailixiang")
	public String chuancailixiang(){
		return "chuancailixiang";
	}
	@RequestMapping("/gongsiyewu")
	public String gongsiyewu(){
		return "gongsiyewu";
	}
	@RequestMapping("/hezuo")
	public String hezuo(){
		return "hezuo";
	}
	@RequestMapping("/jiaruwomen")
	public String jiaruwomen(){
		return "jiaruwomen";
	}
	@RequestMapping("/meishiguan")
	public String meishiguan(){
		return "meishiguan";
	}
	@RequestMapping("/kuaicanpeisong")
	public String kuaicanpeisong(){
		return "kuaicanpeisong";
	}
	@RequestMapping("/lianxiwomen")
	public String lianxiwomen(){
		return "lianxiwomen";
	}
	@RequestMapping("/meishiguangchang")
	public String meishiguangchang(){
		return "meishiguangchang";
	}
	@RequestMapping("/pinpaijieshao")
	public String pinpaijieshao(){
		return "pinpaijieshao";
	}
	@RequestMapping("/pinpailicheng")
	public String pinpailicheng(){
		return "pinpailicheng";
	}
	@RequestMapping("/pinpaishurong")
	public String pinpaishurong(){
		return "pinpaishurong";
	}
	@RequestMapping("/shitangtuoguanchengbao")
	public String shitangtuoguanchengbao(){
		return "shitangtuoguanchengbao";
	}
	@RequestMapping("/tesecaipin")
	public String tesecaipin(){
		return "tesecaipin";
	}
	@RequestMapping("/xinwendongtai")
	public String xinwendongtai(){
		return "xinwendongtai";
	}
	@RequestMapping("/xinwenxiangqing")
	public String xinwenxiangqing(){
		return "xinwenxiangqing";
	}
	@RequestMapping("/adminlogin")
	public String adminlogin(){
		return "adminlogin";
	}
	@RequestMapping("/loginandregister")
	public String loginandregister(){
		return "loginandregister";
	}
	@RequestMapping("/caixibiao")
	public String caixibiao(){
		return "caixibiao";
	}
	@RequestMapping("/caipinbiao")
	public String caipinbiao(){
		return "caipinbiao";
	}
	@RequestMapping("/dingdanbiao")
	public String dingdanbiao(){
		return "dingdanbiao";
	}
	@RequestMapping("/video")
	public String video(){
		return "video";
	}
	@RequestMapping("/UpdateUserInfo")
	public String UpdateUserInfo(String id,String name,String address,String phone,Model model){
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("address",address);
		model.addAttribute("phone",phone);
		return "UpdateUserInfo";
	}
	@RequestMapping("/UpdateMenuClassInfo")
	public String UpdateMenuClassInfo(String id,String name,Model model){
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		return "UpdateMenuClassInfo";
	}
	@RequestMapping("/UpdateMenuInfo")
	public String UpdateMenuInfo(String id,String name,String price,String classs,Model model){
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("price",price);
		model.addAttribute("classs",classs);
		return "UpdateMenuInfo";
	}
	
}
