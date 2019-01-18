package cn.com.lhd.web.controller.fore;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Insurance;
import cn.com.lhd.web.service.IInsuranceService;

/**  
* @desc 前台首页前端控制器   
*  
* @author luohaidian
* @date 2018年11月28日  
* @time 下午8:36:23
*/
@Controller
public class IndexForeController extends CommonController {
	
	@Autowired
	private IInsuranceService iInsuranceService;
	
	/**
	 * 前台首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Insurance insurance = new Insurance();
		insurance.setGroom(true);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(1, 8);
		List<Insurance> insuranceList = iInsuranceService.queryList(insurance, null, sortSet, page);
		mav.addObject("pageTitle", "首页-个人保险管理系统");
		mav.addObject("insuranceList", insuranceList);
		mav.setViewName("/fore/index");
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
		mav.addObject("pageTitle", "关于我们-个人保险管理系统");
		mav.setViewName("/fore/aboutus");
		return mav;
	}

}
