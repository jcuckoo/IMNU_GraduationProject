package cn.com.lhd.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.service.IUserService;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.CryptographyUtil;
import cn.com.lhd.web.utils.ResponseUtil;
/**
 *
 * @desc 用户登录前端控制器
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 上午11:29:26
 */
@Controller
public class LoginController extends CommonController {
	
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tologin")
	public ModelAndView toLogin(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "登录页-个人保险管理系统");
		mav.setViewName("/fore/login");
		return mav;
	}
	
	/**
	 * 管理员登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/back/tologin")
	public ModelAndView toBackLogin(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "后台登录页-个人保险管理系统");
		mav.setViewName("/login");
		return mav;
	}
	
	/**
	 * 注册页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toregister")
	public ModelAndView toRegister(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "注册页-个人保险管理系统");
		mav.setViewName("/fore/register");
		return mav;
	}
	
	/**
	 * 用户登录
	 *  
	 * @param user 用户模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public JsonViewData login(User user, String validateCode){
		String username = user.getUsername();
		String password = user.getPassword();
		if (!BlankUtil.isBlank(validateCode)) {
			String sRand = (String) httpRequest.getSession().getAttribute("sRand");
			if (!sRand.equals(validateCode)) {
				return setJsonViewData(ResultCode.FAIL, "验证码有误，请重新输入！");
			}
		}
		User loadUser = iUserService.queryByUserName(username);
		if (BlankUtil.isBlank(loadUser) || loadUser.getUserRole().getId() != user.getUserRole().getId()) {
			return setJsonViewData(ResultCode.FAIL, "用户名/用户类型有误！");
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, CryptographyUtil.md5(password, CryptographyUtil.SALT));
		try {
			// 登录验证
			subject.login(token);
			return setJsonViewData(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return setJsonViewData(ResultCode.FAIL, "用户名或密码有误！");
		}
	}
	
	/**
	 * 登出/退出系统
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/tologin.html";
	}
	
	/**
	 * 校验用户名
	 * 
	 * @param username 用户名
	 * @throws Exception
	 */
	@RequestMapping(value = "/check/username")
	public void checkUsername(String username) throws Exception{
		User user = new User();
		user.setUsername(username);
		String xml = "";
		if (iUserService.queryCount(user) > 0) {
			xml+="{\"success\":false,\"message\":\"该用户名已经被注册过，请填写其它用户名！\"}";
		}else {
			xml+="{\"success\":true,\"message\":\"\"}";
		}
		ResponseUtil.write(httpResponse, xml);
	}
	
	/**
	 * 用户注册
	 * 
	 * @param user 用户模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register")
	public JsonViewData register(User user){
		boolean success = iUserService.saveOrUpdate(user);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 校验是否登录
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/check/login")
	public JsonViewData checkLogin(){
		if (BlankUtil.isBlank(getCurrentUser())) {
			return setJsonViewData(ResultCode.NO_LOGIN);
		}
		return setJsonViewData(ResultCode.SUCCESS);
	}
	
}
