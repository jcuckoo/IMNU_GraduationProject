package film.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import film.beans.Userinfo;
import film.dao.LoginDao;
import film.dao.RegisterDao;

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
			  me="用户名或密码有错误！";
			  url ="login";
		  }
		  
		  modelAndView.addObject("message", me);  
		  modelAndView.setViewName(url);  
		  return modelAndView;  
		     
		 }
	@RequestMapping("/register")  
	 public ModelAndView register(String username,String userpass,Integer usernumber,Integer usermoney) { 
		Userinfo user = new Userinfo();
		user.setUsername(username);
		user.setUserpass(userpass);
		user.setUsernumber(usernumber);
		user.setUsermoney(usermoney);
		RegisterDao registerDao = new RegisterDao();
	  boolean flag = registerDao.register(user);
	  String me = "";
	  String url ="";
	  if(flag){
		  me="注册成功！";
		  url ="login";
	  }else{
		  me="该用户名已经存在，请重新输入";
		  url ="register";
	  }
	  
	  ModelAndView modelAndView = new ModelAndView();  
	  modelAndView.addObject("message", me);  
	  modelAndView.setViewName(url);  
	  return modelAndView;   
	     
	 }
	@RequestMapping("/logout")  
	 public ModelAndView logout() { 
		
	  String me = "";
	  String url ="";
	  me="注销成功！";
	  url="index";
	  ModelAndView modelAndView = new ModelAndView();  
	  modelAndView.addObject("message", me);  
	  modelAndView.setViewName(url);  
	  return modelAndView;   
	     
	 }
}
