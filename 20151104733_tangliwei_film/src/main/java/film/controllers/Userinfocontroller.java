package film.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import film.beans.Userinfo;

@Controller
public class Userinfocontroller {
	@RequestMapping("/getUserInfo")
   public String getUserInfo(String username,Userinfo userinfo,Model model) {
	  System.out.println(username);
		model.addAttribute("msg", "1111111111");
		
		return "login";
   }
}
