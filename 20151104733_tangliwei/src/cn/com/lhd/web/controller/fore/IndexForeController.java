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
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.service.IAuthorityService;
import cn.com.lhd.web.service.IFilmService;

/**
 *
 * @desc 前台首页前端控制器
 *
 */
@Controller
public class IndexForeController extends CommonController {
	
	@Autowired
	private IAuthorityService iAuthorityService;
	
	@Autowired
	private IFilmService iFilmService;
	
	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		// 最新电影
		Film film = new Film();
		film.setStatus(1);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(1, 6);
		List<Film> newestFilmList = iFilmService.queryList(film, null, sortSet, page);
		mav.addObject("newestFilmList", newestFilmList);
		// 推荐电影
		film.setGroom(true);
		List<Film> groomFilmList = iFilmService.queryList(film, null, sortSet, page);
		mav.addObject("groomFilmList", groomFilmList);
		mav.addObject("pageTitle", "首页-滨海影视网");
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
	 * 关于我们
	 * 
	 * @return
	 */
	@RequestMapping(value = "/aboutus")
	public ModelAndView aboutus(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "关于我们-滨海影视网");
		mav.setViewName("/fore/aboutus");
		return mav;
	}
	
}
