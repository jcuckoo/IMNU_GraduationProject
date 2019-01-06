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
import org.springframework.web.servlet.ModelAndView;

import film.bean.User;
import film.service.LoginService;



/*
 * 用户登录 
 */

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/LoginController",method=RequestMethod.POST)
	public String Login(User userInfo, HttpServletResponse response, HttpSession session, HttpServletRequest request) {
		response.setCharacterEncoding("utf-8");
		String msg = "index";
		try {
			PrintWriter out = response.getWriter();
			List<User> userInfoList = loginService.Login(userInfo);
			if (userInfoList.size() == 0) {
				out.flush();
				out.println("<script>");
				out.println("alert('用户名错误');");
				out.println("history.back();");
				out.println("</script>");
				return msg;
			} else {
				for (User user : userInfoList) {
					if (user.getUserpass().equals(userInfo.getUserpass())) {
						session.setAttribute("user", user);
						session.setAttribute("userName1", user.getUsername());
						msg = "index";
					} else {
						out.flush();
						out.println("<script>");
						out.println("alert('密码错误');");
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
	
	@RequestMapping("/outLogin")
	public String outLogin(HttpSession session){
		//通过session.invalidata()方法来注销当前的session
		session.invalidate();
		return "index";
	}

	
	
}
