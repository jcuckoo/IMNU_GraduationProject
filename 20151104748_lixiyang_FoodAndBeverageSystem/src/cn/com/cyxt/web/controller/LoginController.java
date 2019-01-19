package cn.com.cyxt.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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

import cn.com.cyxt.web.entity.Role;
import cn.com.cyxt.web.entity.User;
import cn.com.cyxt.web.service.IUserService;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.core.utils.CryptographyUtil;
import cn.com.lhd.core.utils.ResponseUtil;

/**
 * 
 * @desc 用户登录前端控制器
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:48:20
 */
@Controller
public class LoginController extends CommonController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IRoleService iRoleService;
	
	/**
	 * 登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tologin")
	public ModelAndView toLogin(){
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<Role> roleList = iRoleService.queryList(null, null, sortSet, null);
		ModelAndView mav = new ModelAndView();
		mav.addObject("roleList", roleList);
		mav.addObject("pageTitle", "登录页-新食尚餐饮系统");
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
		mav.addObject("pageTitle", "注册页-新食尚餐饮系统");
		mav.setViewName("/register");
		return mav;
	}
	
	/**
	 * 用户登录
	 *  
	 * @param user
	 * @param imageCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public JsonViewData login(User user){
		User tempUser = new User();
		String username = user.getUsername();
		String password = user.getPassword();
		tempUser.setUsername(username);
		tempUser.setUserRole(user.getUserRole());
		if (iUserService.queryCount(tempUser) == 0) {
			return setJsonViewData(ResultCode.PARAM_ERROR, "用户名/用户类型有误！");
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, CryptographyUtil.md5(password, CryptographyUtil.SALT));
		try {
			// 登录验证
			subject.login(token);
			Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(1);
			Optional<User> optional = iUserService.queryByUserName(username);
			if (optional.isPresent()) {
				resultMap.put("userType", optional.get().getUserType());
			}
			return setJsonViewData(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return setJsonViewData(ResultCode.FAIL, "用户名或密码有误！");
		}
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/tologin.html";
	}
	
	/**
	 * 校验用户名
	 * @param username
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
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register")
	public JsonViewData register(User user){
		user.setUserType(USERTYPE_C);
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
		if (Objects.isNull(getCurrentUser())) {
			return setJsonViewData(ResultCode.NO_LOGIN);
		}
		return setJsonViewData(ResultCode.SUCCESS);
	}
	
}
