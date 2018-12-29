package com.weather.controller.back;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import cn.com.lhd.core.JsonViewData;
import com.weather.controller.CommonController;
import com.weather.entity.Authority;
import com.weather.service.IAuthorityService;

/**
 * 
 * @desc 后台主页前端控制器
 */
@Controller
@RequestMapping(value = "/manage")
public class IndexBackController extends CommonController {
	
	@Autowired
	private IAuthorityService iAuthorityService;
	
	/**
	 * 后台主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView toIndex(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "后台主页-天气预报系统");
		mav.setViewName("/index");
		return mav;
	}
	
	/**
	 * 权限菜单列表
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/navmenu/list.do")
	public JsonViewData navMenuList(){
		Set<String> fields = Sets.newHashSet("id", "name", "menu_href", "serial_number");
		List<Authority> authorityList = iAuthorityService.queryList(null, fields, null, null);
        authorityList = Authority.build(authorityList);
        Authority.recursionSort(authorityList, Comparator.comparing(Authority::getSerialNumber));
        Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(1);
        resultMap.put("menuList", authorityList);
        return setJsonViewData(resultMap);
	}

}
