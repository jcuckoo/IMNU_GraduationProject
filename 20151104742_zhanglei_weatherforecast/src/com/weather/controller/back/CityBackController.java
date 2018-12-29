package com.weather.controller.back;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.weather.controller.CommonController;
import com.weather.entity.City;
import com.weather.service.ICityService;

/**
 城市管理前端控制器
*/
@Controller
@RequestMapping(value = "/manage/city")
public class CityBackController extends CommonController {
	
	@Autowired
	private ICityService iCityService;
	
	/**
	 * 城市列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "城市管理-天气预报系统");
		mav.setViewName("/back/city/list");
		return mav;
	}
	
	/**
	 * 城市列表信息
	 * 
	 * @param city 城市实体模型
	 * @param pageNo 页号
	
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(City city, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iCityService.queryCount(city);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<City> cityList = totalCount == 0 ? Collections.EMPTY_LIST
				: iCityService.queryList(city, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", cityList);
		mav.setViewName("/back/city/contextlist");
		return mav;
	}
	
	/**
	 * 新增/编辑页
	 * 
	 * @param id 城市Id
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			City city = iCityService.queryById(id);
			mav.addObject("city", city);
		}
		mav.setViewName("/back/city/edit");
		return mav;
	}
	
	/**
	 * 保存
	 * 
	 * @param city 城市实体模型
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(City city) {
		boolean success = iCityService.saveOrUpdate(city);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 删除
	 * 
	 * @param id 城市Id
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(String id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iCityService.delete(Long.valueOf(id));
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "城市Id有误！");
	}

}
