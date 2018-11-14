package com.qst.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qst.bean.User;
import com.qst.service.SelectUserService;

@Controller
public class SelectUserController {

	@Autowired
	private SelectUserService selectUserService;
	
	@RequestMapping(value="/User")
	public String UserList(User userInfo,Model model) {
		
		List<User> userInfoList = selectUserService.select(userInfo);
		
		model.addAttribute("userInfoList", userInfoList);
		//request.setAttribute("userInfoList", userInfoList);
		return "yonghuList";	
	}
	
	@RequestMapping(value="/selectUser",method=RequestMethod.POST)
	public String SelectUser(String keyword,Model model,User userInfo) {
		userInfo.setUser_name(keyword);
		List<User> userInfoList = selectUserService.selectUser(userInfo);
		
		model.addAttribute("userInfoList", userInfoList);
		//request.setAttribute("userInfoList", userInfoList);
		return "yonghuList";	
	}
}
