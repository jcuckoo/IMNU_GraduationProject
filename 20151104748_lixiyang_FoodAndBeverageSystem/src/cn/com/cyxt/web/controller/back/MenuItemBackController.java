package cn.com.cyxt.web.controller.back;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;

import cn.com.cyxt.web.controller.CommonController;
import cn.com.cyxt.web.entity.MenuItem;
import cn.com.cyxt.web.service.IMenuItemService;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;


/**  
* 
* @desc 菜单明细管理前端控制器   
*  
* @author luohaidian
* @date 2018年11月8日  
* @time 下午8:54:08
*/
@Controller
@RequestMapping(value = "/manage/menuItem")
public class MenuItemBackController extends CommonController {
	
	@Autowired
	private IMenuItemService iMenuItemService;
	
	/**
	 * 菜单明细列表页
	 * 
	 * @param menu 菜单明细模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(MenuItem menuItem, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		menuItem.setUserId(getCurrentUser().getId());
		menuItem.setState(0);
		int totalCount = iMenuItemService.queryCount(menuItem);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<MenuItem> menuItemList = totalCount == 0 ? Collections.EMPTY_LIST
				: iMenuItemService.queryList(menuItem, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", menuItemList);
		mav.setViewName("/back/menuItem/contextlist");
		return mav;
	}
	
	/**
	 * 新增备注页
	 * 
	 * @param id 菜单明细Id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id){
		ModelAndView mav = new ModelAndView();
		Optional<MenuItem> optional = iMenuItemService.queryById(id);
		if (optional.isPresent()) {
			mav.addObject("menuItem", optional.get());
		}
		mav.setViewName("/back/menuItem/edit");
		return mav;
	}
	
	/**
	 * 保存菜单明细
	 * 
	 * @param menu 菜单明细模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(MenuItem menuItem) {
		boolean success = iMenuItemService.saveOrUpdate(menuItem);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 删除菜单明细
	 * 
	 * @param id 菜单明细Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iMenuItemService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的菜单明细Id参数有误！");
	}

}
