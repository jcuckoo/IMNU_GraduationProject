package com.qst.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qst.bean.Root;
import com.qst.service.HoutaiService;


@Controller
public class HoutaiLoginController {

	@Autowired
	private HoutaiService houtaiService;
	
	@RequestMapping(value="/HoutaiLoginController",method=RequestMethod.POST)
	public String Login(Root rootInfo, HttpServletResponse response, HttpSession session, HttpServletRequest request) {
		response.setCharacterEncoding("utf-8");
		String msg = "adminlogin";
		try {
			PrintWriter out = response.getWriter();
			List<Root> rootInfoList = houtaiService.Login(rootInfo);
			if (rootInfoList.size() == 0) {
				out.flush();
				out.println("<script>");
				out.println("alert('”√ªß√˚¥ÌŒÛ');");
				out.println("history.back();");
				out.println("</script>");
				return msg;
			} else {
				for (Root root : rootInfoList) {
					if (root.getPasw().equals(rootInfo.getPasw())) {
						session.setAttribute("Root", root);
						session.setAttribute("userName", root.getName());
						session.setAttribute("user_id", root.getId());
						msg = "houtaishouye";
					} else {
						out.flush();
						out.println("<script>");
						out.println("alert('√‹¬Î¥ÌŒÛ');");
						out.println("history.back();");
						out.println("</script>");
						return msg;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
}
