package cn.com.lhd.web.controller.back;

import java.util.Collections;
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
import cn.com.lhd.web.entity.InsuranceType;
import cn.com.lhd.web.service.IInsuranceTypeService;
import cn.com.lhd.web.utils.BlankUtil;

/**
*
* @desc
* 
* @author luohaidian
* @date 2018年12月21日
* @time 上午9:46:09
*/
@Controller
@RequestMapping(value = "/manage/insuranceType")
public class InsuranceTypeBackController extends CommonController {
	
	@Autowired
	private IInsuranceTypeService iInsuranceTypeService;
	
	/**
	 * 保险类别列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "保险类别管理-个人保险管理系统");
		mav.setViewName("/back/insuranceType/list");
		return mav;
	}
	
	/**
	 * 保险类别列表
	 * 
	 * @param insuranceType
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(InsuranceType insuranceType, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iInsuranceTypeService.queryCount(insuranceType);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<InsuranceType> insuranceTypeList = totalCount == 0 ? Collections.EMPTY_LIST
				: iInsuranceTypeService.queryList(insuranceType, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", insuranceTypeList);
		mav.setViewName("/back/insuranceType/contextlist");
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
			InsuranceType insuranceType = iInsuranceTypeService.queryById(id);
			if (!BlankUtil.isBlank(insuranceType)) {
				mav.addObject("insuranceType", insuranceType);
			}
		}
		mav.setViewName("/back/insuranceType/edit");
		return mav;
	}
	
	/**
	 * 保存
	 * 
	 * @param insuranceType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(InsuranceType insuranceType){
		boolean success = iInsuranceTypeService.saveOrUpdate(insuranceType);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (!BlankUtil.isBlank(id)) {
			boolean deleted = iInsuranceTypeService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "保险类别Id参数有误！");
	}

}
