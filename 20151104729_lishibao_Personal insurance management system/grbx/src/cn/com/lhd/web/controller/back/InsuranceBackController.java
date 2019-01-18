package cn.com.lhd.web.controller.back;

import java.util.Collections;
import java.util.Date;
import java.util.List;
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
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Company;
import cn.com.lhd.web.entity.Insurance;
import cn.com.lhd.web.entity.InsuranceType;
import cn.com.lhd.web.entity.Order;
import cn.com.lhd.web.service.ICompanyService;
import cn.com.lhd.web.service.IInsuranceService;
import cn.com.lhd.web.service.IInsuranceTypeService;
import cn.com.lhd.web.service.IOrderService;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.DateUtil;

/**
 * 
 * @desc 保险信息管理前端控制器
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午9:01:08
 */
@Controller
@RequestMapping(value = "/manage/insurance")
public class InsuranceBackController extends CommonController {
	
	@Autowired
	private IInsuranceService iInsuranceService;
	
	@Autowired
	private ICompanyService iCompanyService;
	
	@Autowired
	private IInsuranceTypeService iInsuranceTypeService;
	
	@Autowired
	private IOrderService iOrderService;
	
	/**
	 * 保险信息列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<InsuranceType> insuranceTypeList = iInsuranceTypeService.queryList(null, sortSet, null);
		mav.addObject("insuranceTypeList", insuranceTypeList);
		mav.addObject("pageTitle", "保险信息管理-个人保险管理系统");
		mav.setViewName("/back/insurance/list");
		return mav;
	}
	
	/**
	 * 保险信息列表
	 * 
	 * @param insurance
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Insurance insurance, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iInsuranceService.queryCount(insurance);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Insurance> insuranceList = totalCount == 0 ? Collections.EMPTY_LIST
				: iInsuranceService.queryList(insurance, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", insuranceList);
		mav.setViewName("/back/insurance/contextlist");
		return mav;
	}
	
	/**
	 * 新增/编辑页
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id){
		ModelAndView mav = new ModelAndView();
		if (!BlankUtil.isBlank(id)) {
			Insurance insurance = iInsuranceService.queryById(id);
			if (!BlankUtil.isBlank(insurance)) {
				mav.addObject("insurance", insurance);
			}
		}
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		List<InsuranceType> insuranceTypeList = iInsuranceTypeService.queryList(null, sortSet, null);
		mav.addObject("insuranceTypeList", insuranceTypeList);
		List<Company> companyList = iCompanyService.queryList(null, null, sortSet, null);
		mav.addObject("companyList", companyList);
		mav.setViewName("/back/insurance/edit");
		return mav;
	}
	
	/**
	 * 保存保险信息
	 * 
	 * @param insurance
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(Insurance insurance){
		if (BlankUtil.isBlank(insurance.getId())) {
			insurance.setNumber(DateUtil.formatCurrentDate("yyyyMMddHHmmss"));
		}
		if (!BlankUtil.isBlank(insurance.getContent())) {
			String summary = BlankUtil.Html2Text(insurance.getContent());
			summary = summary.length() > 80 ? summary.substring(0, 80) : summary;
			insurance.setSummary(summary);
		}
		boolean success = iInsuranceService.saveOrUpdate(insurance);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 删除保险信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (!BlankUtil.isBlank(id)) {
			boolean deleted = iInsuranceService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "保险Id参数有误！");
	}
	
	/**
	 * 购买保险
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/buy")
	public JsonViewData buy(Long id) {
		if (BlankUtil.isBlank(getCurrentUser())) {
			return setJsonViewData(ResultCode.NO_LOGIN);
		}
		Insurance insurance = iInsuranceService.queryById(id);
		if (!BlankUtil.isBlank(insurance)) {
			Order order = new Order();
			Date date = new Date();
			order.setNumber(DateUtil.convertDateToStr(date, "yyyyMMddHHmmsss"));
			order.setUser(getCurrentUser());
			order.setUserName(getCurrentUser().getTruename());
			order.setMoney(insurance.getMoney());
			order.setInsurance(insurance);
			order.setInsuranceName(insurance.getTitle());
			order.setBeginTime(date);
			order.setEndTime(DateUtil.getAfferYear(insurance.getDueTime()));
			boolean success = iOrderService.saveOrUpdate(order);
			return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
		}
		return setJsonViewData(ResultCode.FAIL);
	}

}
