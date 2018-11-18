package film.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import film.beans.Userinfo;
import film.dao.LoginDao;

@Controller
public class Userinfocontroller {
	@RequestMapping("/login")
	 public ModelAndView login(String username,String userpass) { 
		Userinfo user = new Userinfo();
		user.setUsername(username);
		user.setUserpass(userpass);
		   LoginDao loginDao = new LoginDao();
		  boolean flag = loginDao.login(user);
		  ModelAndView modelAndView = new ModelAndView();  
		  String me = "";
		  String url ="";
		  if(flag){
			  me="欢迎尊贵的：";

			  modelAndView.addObject("username", username);  
			  url ="index";
		  }else{
			  me="用户名和密码有错误！";
			  url ="login";
		  }
		  
		  modelAndView.addObject("message", me);  
		  modelAndView.setViewName(url);  
		  return modelAndView;  
		     
		 }
}
