package com.qst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.bean.User;
import com.qst.service.CheckUserService;

@Controller
public class CheckUserController {
	
	@Autowired
	private CheckUserService checkUserService;
	
	@RequestMapping(value="/User")
	public String UserList(User userInfo,Model model) {
		List<User> userInfoList = checkUserService.check(userInfo);
		model.addAttribute("userInfoList", userInfoList);
		return "";
	}

}
