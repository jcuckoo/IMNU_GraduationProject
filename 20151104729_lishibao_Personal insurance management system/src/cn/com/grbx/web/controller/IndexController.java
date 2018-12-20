package cn.com.lhd.web.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.web.CommonController;
import cn.com.lhd.web.entity.Authority;
import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.service.IAuthorityService;
import cn.com.lhd.web.service.IRoleAuthorityService;

/**
 * 
 * @desc 后台主页前端控制器
 *
 * @author luohaidian
 * @date 2018年10月21日
 * @time 下午10:29:01
 */
@Controller
@RequestMapping(value = "/manage")
public class IndexController extends CommonController {
	
	@Autowired
	private IAuthorityService iAuthorityService;
	
	@Autowired
	private IRoleAuthorityService iRoleAuthorityService;
	
	/**
	 * 后台主页
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView toIndex(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "后台主页-个人保险管理系统");
		mav.setViewName("/index");
		return mav;
	}
	
	/**
	 * 权限菜单列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/navmenu/list.do")
	public JsonViewData navMenuList(){
		User currentUser = getCurrentUser();
		Long roleId = currentUser.getUserRole().getId();
		Set<Long> authorityIds = iRoleAuthorityService.queryByRoleId(roleId);
		List<Authority> authorityList = Lists.newLinkedList();
		for (Long authorityId : authorityIds) {
			Authority authority = iAuthorityService.queryById(authorityId);
			authorityList.add(authority);
		}
        authorityList = Authority.build(authorityList);
        Authority.recursionSort(authorityList, Comparator.comparing(Authority::getSerialNumber));
        Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(1);
        resultMap.put("menuList", authorityList);
        return setJsonViewData(resultMap);
	}

}
