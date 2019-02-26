package cn.com.lhd.web.controller.back;

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

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Authority;
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.entity.FilmType;
import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.service.IAuthorityService;
import cn.com.lhd.web.service.IFilmService;
import cn.com.lhd.web.service.IFilmTypeService;
import cn.com.lhd.web.service.IRoleAuthorityService;

/**
 *
 * @desc 后台首页前端控制器
 *
 */
@Controller
@RequestMapping(value = "/manage")
public class IndexBackController extends CommonController {
	
	@Autowired
	private IAuthorityService iAuthorityService;
	
	@Autowired
	private IRoleAuthorityService iRoleAuthorityService;
	
	@Autowired
	private IFilmTypeService iFilmTypeService;
	
	@Autowired
	private IFilmService iFilmService;
	
	/**
	 * 后台主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView toIndex(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "后台主页-滨海影视网");
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
		// 电影类别归档
		List<FilmType> fileTypeCountList = iFilmTypeService.queryWithFilmCount();
		application.setAttribute("fileTypeCountList", fileTypeCountList);
		
		// 热门电影
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("click_count", false));
		IPage page = new SimplePage(1, 10);
		Film film = new Film();
		film.setStatus(1);
		List<Film> hotFilmList = iFilmService.queryList(film, null, sortSet, page);
		application.setAttribute("hotFilmList", hotFilmList);
		return setJsonViewData(ResultCode.SUCCESS);
	}
	
}
