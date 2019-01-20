package com.imnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends CommonController{
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/index/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("index/youxun");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/dept/{formName}")
		 public String index2(@PathVariable String formName){
//			return formName;
			String blank = "/dept/list";
			return blank;
		}
		
		@RequestMapping(value="/index/youxun",method=RequestMethod.GET)
		 public String index(Model model,String content){
//			System.out.println("4234");
			
//			for(Dept attribute : dept_list) {
//				  System.out.println(attribute.getName());
//				}
			return "index/youxun";
		}


}
