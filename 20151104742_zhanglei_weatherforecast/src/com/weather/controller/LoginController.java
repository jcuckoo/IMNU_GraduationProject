package com.weather.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.sort.Sorter;
import com.weather.entity.City;
import com.weather.entity.Role;
import com.weather.entity.User;
import com.weather.service.ICityService;
import com.weather.service.IRoleService;
import com.weather.service.IUserService;
import com.weather.utils.CryptographyUtil;
import com.weather.utils.ResponseUtil;

/**
   用户登录/注册前端控制器
 */
@Controller
public class LoginController extends CommonController {
	
	@Autowired
	private IRoleService iRoleService;
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private ICityService iCityService;
	
	/**
	 * 登录页
	 */
	@RequestMapping(value = "/tologin")
	public ModelAndView toLogin(){
		ModelAndView mav = new ModelAndView();
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<Role> roleList = iRoleService.queryList(null, null, sortSet, null);
		mav.addObject("roleList", roleList);
		mav.addObject("pageTitle", "登录页-天气预报系统");
		mav.setViewName("login");
		return mav;
	}
	
	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public JsonViewData login(User user){
		User tempUser = new User();
		tempUser.setUsername(user.getUsername());
		tempUser.setUserRole(user.getUserRole());
		if (iUserService.queryCount(tempUser) == 0) {
			return setJsonViewData(ResultCode.PARAM_ERROR, "用户名/用户类型有误！");
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
				CryptographyUtil.md5(user.getPassword(), CryptographyUtil.SALT));
		try {
			// 登录验证
			subject.login(token); 
			Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(1);
			User loadUser = iUserService.queryByUserName(user.getUsername());
			resultMap.put("userType", loadUser.getUserType());
			return setJsonViewData(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return setJsonViewData(ResultCode.FAIL, "用户名或密码有误！");
		}
	}
	
	/**
	 * 注册页
	 */
	@RequestMapping(value = "/toregister")
	public ModelAndView toRegister(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "注册页-天气预报系统");
		mav.setViewName("/register");
		return mav;
	}
	
	/**
	 * 登出
	 */
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/index.html";
	}
	
	/**
	 * 校验身份证号
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
	 */
	@ResponseBody
	@RequestMapping(value = "/register")
	public JsonViewData register(User user){
		String address = user.getAddress();
		String cityName = address.substring(address.indexOf("省") + 1, address.length());
		City city = new City();
		city.setName(cityName);
		if (iCityService.queryCount(city) == 0) {
			city.setProvince(address.substring(0, address.indexOf("省") + 1));
			iCityService.saveOrUpdate(city);
		}
		user.setUserType(USERTYPE_C);
		boolean success = iUserService.saveOrUpdate(user);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}

}
