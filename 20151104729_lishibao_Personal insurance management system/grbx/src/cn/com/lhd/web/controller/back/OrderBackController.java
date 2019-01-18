package cn.com.lhd.web.controller.back;

import java.util.Collections;
import java.util.List;
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
import cn.com.lhd.web.entity.Order;
import cn.com.lhd.web.service.IOrderService;
import cn.com.lhd.web.utils.BlankUtil;

/**
*
* @desc 保单管理前端控制器
* 
* @author luohaidian
* @date 2018年12月21日
* @time 下午2:05:56
*/
@Controller
@RequestMapping(value = "/manage/order")
public class OrderBackController extends CommonController {
	
	@Autowired
	private IOrderService iOrderService;
	
	/**
	 * 保单列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "保单信息管理-个人保险管理系统");
		mav.setViewName("/back/order/list");
		return mav;
	}
	
	/**
	 * 保单信息列表
	 * 
	 * @param order
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Order order, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		if (getCurrentUser().getUserRole().getName().equals(USERTYPE_C)) {
			order.setUser(getCurrentUser());
		}
		int totalCount = iOrderService.queryCount(order);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Order> orderList = totalCount == 0 ? Collections.EMPTY_LIST
				: iOrderService.queryList(order, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", orderList);
		mav.setViewName("/back/order/contextlist");
		return mav;
	}
	
	/**
	 * 删除保单
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (!BlankUtil.isBlank(id)) {
			boolean deleted = iOrderService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "保单Id参数有误！");
	}
	
	/**
	 * 保单详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		Order order = iOrderService.queryById(id);
		if (!BlankUtil.isBlank(order)) {
			mav.addObject("order", order);
		}
		mav.setViewName("/back/order/view");
		return mav;
	}
	
	/**
	 * 审批保单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/approve")
	public JsonViewData approve(Long id) {
		Order order = new Order();
		order.setId(id);
		order.setState(1);
		boolean success = iOrderService.saveOrUpdate(order);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}

}
