package com.yq.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;

/**
 * 登陆拦截器.
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
//	public static final String appid = "wxe6473058b265185a";
//	public static final String link = "http://www.7haodian.cc/chihaodian";
//	public static final String appsecret = "cbcef8220cf134c1de794b81bafd52af";
	private Logger log = Logger.getLogger(getClass());
			
	private static final String[] IGNORE_URI = { "/login.jsp", "/Login/", "/reply.html", "/main/", "/admin/", "/userInsert.html",
			"/oauth2/", "/noticeOrder.html" };
	Gson gson=new Gson();
	Map<String, Object> map = new HashMap<String, Object>();
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		boolean flag = false;

		flag = session.getAttribute("oppen_id") != null ? true : false;
		String url = (request.getRequestURL() + "?" + request.getQueryString()).toString();
		System.out.println(">>>: " + url);
		for(String s : IGNORE_URI) {
			if (url.contains(s)) {
				flag = true;
				break;
			}
		}
		log.info("url>>>: " + url);
		if (!flag) {
			AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(new String []{"classpath:applicationContext.xml"});
			
			
			
		}
		
		log.info("最终 flag=="+flag);
		
//		flag=true ;
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}