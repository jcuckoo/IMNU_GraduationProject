package cn.com.lhd.web.controller.fore;

import java.util.Collections;
import java.util.List;
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
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Insurance;
import cn.com.lhd.web.entity.InsuranceType;
import cn.com.lhd.web.service.IInsuranceService;
import cn.com.lhd.web.service.IInsuranceTypeService;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.PageUtil;

/**  
* @desc 保险中心前端控制器   
*  
* @author luohaidian
* @date 2018年12月19日  
* @time 下午9:06:58
*/
@Controller
@RequestMapping(value = "/insurance")
public class InsuranceForeController extends CommonController {
	
	@Autowired
	private IInsuranceService iInsuranceService;
	
	@Autowired
	private IInsuranceTypeService iInsuranceTypeService;
	
	/**
	 * 保险中心列表页
	 * 
	 * @param insurance
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Insurance insurance, @RequestParam(name = "pageNo", defaultValue = "1") int pageNo){
		ModelAndView mav = new ModelAndView();
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		List<InsuranceType> insuranceTypeList = iInsuranceTypeService.queryList(null, sortSet, null);
		mav.addObject("insuranceTypeList", insuranceTypeList);
		int totalCount = iInsuranceService.queryCount(insurance);
		IPage page = new SimplePage(pageNo, pageSize);
		List<Insurance> insuranceList = totalCount == 0 ? Collections.EMPTY_LIST
				: iInsuranceService.queryList(insurance, null, sortSet, page);
		mav.addObject("datalist", insuranceList);
		StringBuffer param = new StringBuffer();
		if (!BlankUtil.isBlank(insurance.getInsuranceType()) && !BlankUtil.isBlank(insurance.getInsuranceType().getId())) {
			param.append("&insuranceType.id=" + insurance.getInsuranceType().getId());
			mav.addObject("insuranceTypeId", insurance.getInsuranceType().getId());
		}
		mav.addObject("pageCode", PageUtil.genPagination(httpRequest.getContextPath() + "/insurance/list.html", totalCount,
				pageNo, pageSize, param.toString()));
		mav.addObject("pageTitle", "保险中心-个人保险管理系统");
		mav.addObject("navTitle", "首页  &gt;&gt; 保险中心");
		mav.addObject("mainPage", "/pages/fore/insurance/default.jsp");
		mav.setViewName("/fore/insurance/index");
		return mav;
	}
	
	/**
	 * 保险详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView();
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		List<InsuranceType> insuranceTypeList = iInsuranceTypeService.queryList(null, sortSet, null);
		mav.addObject("insuranceTypeList", insuranceTypeList);
		Insurance insurance = iInsuranceService.queryById(id);
		if (!BlankUtil.isBlank(insurance)) {
			mav.addObject("insurance", insurance);
			mav.addObject("navTitle", "首页  &gt;&gt; 保险中心   &gt;&gt; " + insurance.getTitle());
		}
		mav.addObject("pageTitle", "保险中心-个人保险管理系统");
		mav.addObject("mainPage", "/pages/fore/insurance/view.jsp");
		mav.setViewName("/fore/insurance/index");
		return mav;
	}

}
