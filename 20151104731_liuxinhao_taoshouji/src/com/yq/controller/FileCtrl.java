package com.yq.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/main")
public class FileCtrl {
	
	@ResponseBody
	@RequestMapping(value="/upload.html")
	public Object upload(@RequestParam MultipartFile file,HttpServletRequest request){
			String realpath = request.getSession().getServletContext().getRealPath(""); 
			String path = "";
			if(realpath.contains("\\")){
				 path = realpath.substring(0,realpath.lastIndexOf("\\"))+"/upload";
			}else{
				 path = realpath.substring(0,realpath.lastIndexOf("/"))+"/upload";
			}
			System.out.println("path="+path);
//			String fileName = file.getOriginalFilename();  
	        String fileName = new Date().getTime()+".png";  
	        
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
	        
	      
			return null;  
	}
}
