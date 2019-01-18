package cn.com.lhd.web.controller.back;

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
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Company;
import cn.com.lhd.web.entity.Insurance;
import cn.com.lhd.web.service.ICompanyService;
import cn.com.lhd.web.service.IInsuranceService;
import cn.com.lhd.web.utils.BlankUtil;

/**
 * 
 * @desc 保险公司管理前端控制器
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午10:19:25
 */
@Controller
@RequestMapping(value = "/manage/company")
public class CompanyBackController extends CommonController {
	
	@Autowired
	private ICompanyService iCompanyService;
	
	@Autowired
	private IInsuranceService iInsuranceService;
	
	/**
	 * 保险公司列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "保险公司管理-个人保险管理系统");
		mav.setViewName("/back/company/list");
		return mav;
	}
	
	/**
	 * 保险公司列表
	 * 
	 * @param company
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Company company, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iCompanyService.queryCount(company);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Company> companyList = totalCount == 0 ? Collections.EMPTY_LIST
				: iCompanyService.queryList(company, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", companyList);
		mav.setViewName("/back/company/contextlist");
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
		if (Objects.nonNull(id)) {
			Company company = iCompanyService.queryById(id);
			if (!BlankUtil.isBlank(company)) {
				mav.addObject("company", company);
			}
		}
		mav.setViewName("/back/company/edit");
		return mav;
	}
	
	/**
	 * 保存保险公司
	 * 
	 * @param company
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(Company company){
		boolean success = iCompanyService.saveOrUpdate(company);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 删除保险公司
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (!BlankUtil.isBlank(id)) {
				Insurance insurance = new Insurance();
				insurance.setCompany(new Company(id));
				if (iInsuranceService.queryCount(insurance) > 0) {
					return setJsonViewData(ResultCode.FAIL, "该公司关联有保险信息，故不能删除！");
				}
			boolean deleted = iCompanyService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "用户Id参数有误！");
	}

}
