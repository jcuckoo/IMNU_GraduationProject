package cn.com.cyxt.web.controller.back;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Menu;
import cn.com.lhd.web.entity.MenuItem;
import cn.com.lhd.web.entity.MenuType;
import cn.com.lhd.web.service.IMenuItemService;
import cn.com.lhd.web.service.IMenuService;
import cn.com.lhd.web.service.IMenuTypeService;

/**  
* 
* @desc 菜单管理前端控制器   
*  
* @author luohaidian
* @date 2018年11月8日  
* @time 下午8:54:08
*/
@Controller
@RequestMapping(value = "/manage/menu")
public class MenuBackController extends CommonController {
	
	@Autowired
	private IMenuService iMenuService;
	
	@Autowired
	private IMenuTypeService iMenuTypeService;
	
	@Autowired
	private IMenuItemService iMenuItemService;
	
	/**
	 * 菜单页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		String userType = getCurrentUser().getUserType();
		if (userType.equals(USERTYPE_C)) {
			mav.setViewName("/back/menuItem/list");
		} else if (userType.equals(USERTYPE_M)) {
			Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
			List<MenuType> menuTypeList = iMenuTypeService.queryList(null, null, sortSet, null);
			mav.addObject("menuTypeList", menuTypeList);
			mav.setViewName("/back/menu/list");
		}
		return mav;
	}
	
	/**
	 * 菜单列表页
	 * 
	 * @param menu 菜单模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Menu menu, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iMenuService.queryCount(menu);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Menu> menuList = totalCount == 0 ? Collections.EMPTY_LIST
				: iMenuService.queryList(menu, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", menuList);
		mav.setViewName("/back/menu/contextlist");
		return mav;
	}
	
	/**
	 * 新增/编辑页
	 * 
	 * @param id 菜单Id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			Optional<Menu> optional = iMenuService.queryById(id);
			if (optional.isPresent()) {
				mav.addObject("menu", optional.get());
			}
		}
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		List<MenuType> menuTypeList = iMenuTypeService.queryList(null, null, sortSet, null);
		mav.addObject("menuTypeList", menuTypeList);
		mav.setViewName("/back/menu/edit");
		return mav;
	}
	
	/**
	 * 保存
	 * 
	 * @param menu 菜单模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(Menu menu) {
		boolean success = iMenuService.saveOrUpdate(menu);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 菜谱详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			Optional<Menu> optional = iMenuService.queryById(id);
			if (optional.isPresent()) {
				mav.addObject("menu", optional.get());
			}
		}
		mav.setViewName("/back/menu/view");
		return mav;
	}
	
	/**
	 * 删除菜单
	 * 
	 * @param id 菜单Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iMenuService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的菜单Id参数有误！");
	}
	
	/**
	 * 预订菜单
	 * 
	 * @param id 菜单Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/book")
	public JsonViewData book(Long id) {
		Optional<Menu> optional = iMenuService.queryById(id);
		if (optional.isPresent()) {
			Menu menu = optional.get();
			// 更新下单次数
			Menu vo = new Menu();
			vo.setId(id);
			vo.setBuyCount(menu.getBuyCount() + 1);
			iMenuService.saveOrUpdate(vo);
			MenuItem menuItem = new MenuItem();
			menuItem.setMenuId(menu.getId());
			menuItem.setMenuName(menu.getName());
			menuItem.setMenuPrice(menu.getPrice());
			menuItem.setUserId(getCurrentUser().getId());
			menuItem.setUserName(getCurrentUser().getName());
			boolean success = iMenuItemService.saveOrUpdate(menuItem);
			return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
		}
		return setJsonViewData(ResultCode.PARAM_ERROR, "菜单Id有误！");
	}

}
