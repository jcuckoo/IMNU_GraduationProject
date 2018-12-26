package cn.com.cyxt.web.controller.fore;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.core.utils.BlankUtil;
import cn.com.lhd.core.utils.PageUtil;


/**
 *
 * @desc 菜单库前端控制器
 * 
 * @author luohaidian
 * @date 2018年11月8日
 * @time 下午4:10:52
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuForeController extends CommonController {

	@Autowired
	private IMenuTypeService iMenuTypeService;

	@Autowired
	private IMenuService iMenuService;
	
	/**
	 * 菜单库
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Menu menu, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		int totalCount = iMenuService.queryCount(menu);
		sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Menu> menuList = totalCount == 0 ? Collections.EMPTY_LIST
				: iMenuService.queryList(menu, null, sortSet, page);
		List<MenuType> menuTypeList = iMenuTypeService.queryList(null, null, sortSet, null);
		StringBuffer param = new StringBuffer();
		ModelAndView mav = new ModelAndView();
		if (!BlankUtil.isBlank(menu.getName())) {
			param.append("name=" + menu.getName() + "&");
		}
		if (Objects.nonNull(menu.getMenuType()) && Objects.nonNull(menu.getMenuType().getId())) {
			param.append("menuType.id=" + menu.getMenuType().getId() + "&");
		}
		mav.addObject("pageCode", PageUtil.genPagination(httpRequest.getContextPath() + "/menu/list.html", totalCount,
				pageNo, pageSize, param.toString()));
		mav.addObject("menuTypeList", menuTypeList);
		mav.addObject("datalist", menuList);
		mav.addObject("pageTitle", "菜单库-新食尚餐饮系统");
		mav.addObject("navTitle", "首页  &gt;&gt; 菜单库");
		mav.addObject("mainPage", "/pages/fore/menu/default.jsp");
		mav.setViewName("/fore/menu/index");
		return mav;
	}
	
	/**
	 * 菜谱详情
	 * 
	 * @param id 菜谱Id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		Optional<Menu> optional = iMenuService.queryById(id);
		if (optional.isPresent()) {
			Menu menu = optional.get();
			mav.addObject("menu", menu);
			// 预览次数加1
			Menu vo = new Menu();
			vo.setId(id);
			vo.setHitCount(menu.getHitCount() + 1);
			iMenuService.saveOrUpdate(vo);
		}
		mav.addObject("pageTitle", "菜谱详情-新食尚餐饮系统");
		mav.addObject("navTitle", "首页  &gt;&gt; 菜单详情");
		mav.addObject("mainPage", "/pages/fore/menu/view.jsp");
		mav.setViewName("/fore/menu/index");
		return mav;
	}
	
}
