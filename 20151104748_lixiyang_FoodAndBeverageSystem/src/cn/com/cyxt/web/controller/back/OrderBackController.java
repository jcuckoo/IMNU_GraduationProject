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

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import cn.com.cyxt.web.controller.CommonController;
import cn.com.cyxt.web.entity.MenuItem;
import cn.com.cyxt.web.entity.Order;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.core.utils.DateUtil;


/**
*
* @desc 订单管理前端控制器
* 
* @author luohaidian
* @date 2018年11月9日
* @time 下午4:06:38
*/
@Controller
@RequestMapping(value = "/manage/order")
public class OrderBackController extends CommonController {
	
	@Autowired
	private IOrderService iOrderService;
	
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
		mav.setViewName("/back/order/list");
		return mav;
	}
	
	/**
	 * 订单列表
	 * 
	 * @param order 订单模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Order order, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
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
	 * 保存订单
	 * 
	 * @param id 菜单明细Id集
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(String id) {
		Order order = new Order();
		order.setUserName(getCurrentUser().getName());
		order.setOrderNo(DateUtil.formatCurrentDate("yyyyMMddHHmmss"));
		String[] ids = id.split(",");
		double price = 0;
		StringBuffer menuNames = new StringBuffer();
		StringBuffer remarks = new StringBuffer();
		for (String idStr : ids) {
			Optional<MenuItem> optional = iMenuItemService.queryById(Long.parseLong(idStr));
			if (optional.isPresent()) {
				MenuItem menuItem = optional.get();
				price += menuItem.getMenuPrice();
				menuNames.append(menuItem.getMenuName() + ";");
				if (!Strings.isNullOrEmpty(menuItem.getRemark())) {
					remarks.append(menuItem.getMenuName() + "-" + menuItem.getRemark() + ";");
				}
				// 更新订单明细的付款状态
				MenuItem mItem = new MenuItem();
				mItem.setId(Long.parseLong(idStr));
				mItem.setState(1);
				iMenuItemService.saveOrUpdate(mItem);
			}
		}
		order.setPrice(price);
		order.setMenuNames(menuNames.toString());
		order.setRemark(remarks.toString());
		boolean success = iOrderService.save(order);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 订单备注
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable(value = "id") Long id) {
		ModelAndView mav = new ModelAndView();
		Optional<Order> optional = iOrderService.queryById(id);
		if (optional.isPresent()) {
			mav.addObject("order", optional.get());
		}
		mav.setViewName("/back/order/view");
		return mav;
	}
	
	/**
	 * 删除订单
	 * 
	 * @param id 订单Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iOrderService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的订单Id参数有误！");
	}

}
