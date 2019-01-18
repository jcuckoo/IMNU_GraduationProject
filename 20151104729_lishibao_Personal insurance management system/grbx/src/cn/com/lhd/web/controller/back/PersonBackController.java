package cn.com.lhd.web.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.service.IUserService;
import cn.com.lhd.web.utils.BlankUtil;

/**
 * 
 * @desc 个人信息前段控制器
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:58:49
 */
@Controller
@RequestMapping(value = "/manage/person")
public class PersonBackController extends CommonController {
	
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 个人信息页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		User loadUser = iUserService.queryById(getCurrentUser().getId());
		if (!BlankUtil.isBlank(loadUser)) {
			mav.addObject("user", loadUser);
		}
		mav.addObject("pageTitle", "个人信息管理-个人保险管理系统");
		mav.setViewName("/back/person/info");
		return mav;
	}
	
	/**
	 * 保存个人信息
	 * 
	 * @param user 用户模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(User user){
		boolean success = iUserService.saveOrUpdate(user);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
}
