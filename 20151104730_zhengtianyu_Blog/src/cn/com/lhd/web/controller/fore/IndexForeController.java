package cn.com.lhd.web.controller.fore;

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

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Authority;
import cn.com.lhd.web.entity.Blog;
import cn.com.lhd.web.entity.Role;
import cn.com.lhd.web.service.IAuthorityService;
import cn.com.lhd.web.service.IBlogService;
import cn.com.lhd.web.service.IRoleService;

/**
 * 
 * @desc 前台首页前端控制器
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:45:53
 */
@Controller
public class IndexForeController extends CommonController {
	
	@Autowired
	private IAuthorityService iAuthorityService;
	
	@Autowired
	private IRoleService iRoleService;
	
	@Autowired
	private IBlogService iBlogService;
	
	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		// 最新博客文章
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(1, 6);
		List<Blog> blogList = iBlogService.queryList(null, null, sortSet, page);
		mav.addObject("newestList", blogList);
		// 推荐文章
		Blog blog = new Blog();
		blog.setGroom(true);
		blogList = iBlogService.queryList(blog, null, sortSet, page);
		mav.addObject("groomList", blogList);
		mav.addObject("pageTitle", "首页-个人博客系统");
		mav.addObject("mainPage", "/pages/fore/default.jsp");
		mav.setViewName("/fore/index");
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
		Authority authority = new Authority();
		authority.setMenuType("1");
		authority.setMenuPosition("1");
		Set<String> fields = Sets.newHashSet("id", "name", "serial_number", "menu_href");
		List<Authority> authorityList = iAuthorityService.queryList(authority, fields, null, null);
        authorityList = Authority.build(authorityList);
        Authority.recursionSort(authorityList, Comparator.comparing(Authority::getSerialNumber));
        Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(1);
        resultMap.put("menuList", authorityList);
        return setJsonViewData(resultMap);
	}
	
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
		mav.addObject("pageTitle", "登录页-个人博客系统");
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
		mav.addObject("pageTitle", "注册页-个人博客系统");
		mav.setViewName("/fore/register");
		return mav;
	}
	
	/**
	 * 关于我们
	 * 
	 * @return
	 */
	@RequestMapping(value = "/aboutus")
	public ModelAndView aboutus(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "关于博主-个人博客系统");
		mav.setViewName("/fore/aboutus");
		return mav;
	}

}
