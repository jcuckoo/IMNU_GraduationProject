package film.controller;

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

import film.bean.Root;
import film.service.RootService;




@Controller
public class RootLoginController {

	@Autowired
	private RootService rootService;
	
	@RequestMapping(value="/RootController",method=RequestMethod.POST)
	public String Login(Root rootInfo, HttpServletResponse response, HttpSession session, HttpServletRequest request) {
		response.setCharacterEncoding("utf-8");
		String msg = "adminlogin";
		try {
			PrintWriter out = response.getWriter();
			List<Root> rootInfoList = rootService.Login(rootInfo);
			if (rootInfoList.size() == 0) {
				out.flush();
				out.println("<script>");
				out.println("alert('”√ªß√˚¥ÌŒÛ');");
				out.println("history.back();");
				out.println("</script>");
				return msg;
			} else {
				for (Root root : rootInfoList) {
					if (root.getPassword().equals(rootInfo.getPassword())) {
						session.setAttribute("Root", root);
						session.setAttribute("userName", root.getRoot());
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
