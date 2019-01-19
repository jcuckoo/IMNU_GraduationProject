package cn.com.cyxt.web.controller.back;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import cn.com.cyxt.web.controller.CommonController;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;


/**
 * 
 * @desc 首页前端控制器
 *
 * @author luohaidian
 * @date 2018年11月7日
 * @time 下午8:36:30
 */
@Controller
@RequestMapping(value = "/manage")
public class IndexBackController extends CommonController {
	
	@Autowired
	private IAuthorityService iAuthorityService;
	
	@Autowired
	private IRoleAuthorityService iRoleAuthorityService;
	
	@Autowired
	private IMenuTypeService iMenuTypeService;
	
	@Autowired
	private IMenuService iMenuService;
	
	/**
	 * 后台主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView toIndex(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "后台主页-新食尚餐饮系统");
		mav.setViewName("/back/index");
		return mav;
	}
	
	/**
	 * 导航栏菜单
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/navmenu/list")
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
	
	/**
	 * 刷新缓存
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/refresh")
	public JsonViewData refresh(){
		ServletContext application = RequestContextUtils.getWebApplicationContext(httpRequest).getServletContext();
		// 菜系类别归档
		List<MenuType> menuTypeCountList = iMenuTypeService.queryWithMenuCount();
		application.setAttribute("menuTypeCountList", menuTypeCountList);
		
		// 菜单排行
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("buy_count", false));
		IPage page = new SimplePage(1, 10);
		List<Menu> hotMenuList = iMenuService.queryList(null, null, sortSet, page);
		application.setAttribute("hotMenuList", hotMenuList);
		return setJsonViewData(ResultCode.SUCCESS);
	}
	
}
