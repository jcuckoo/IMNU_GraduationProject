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
import cn.com.cyxt.web.entity.Stock;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;

/**
*
* @desc 产品库存管理前端控制器
* 
* @author luohaidian
* @date 2018年11月9日
* @time 下午4:06:38
*/
@Controller
@RequestMapping(value = "/manage/stock")
public class StockBackController extends CommonController {
	
	@Autowired
	private IStockService iStockService;
	
	/**
	 * 产品库存列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/stock/list");
		return mav;
	}
	
	/**
	 * 产品库存列表
	 * 
	 * @param stock 产品库存模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Stock stock, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iStockService.queryCount(stock);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Stock> stockList = totalCount == 0 ? Collections.EMPTY_LIST
				: iStockService.queryList(stock, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", stockList);
		mav.setViewName("/back/stock/contextlist");
		return mav;
	}
	
	/**
	 * 新增/编辑页
	 * 
	 * @param id 产品库存Id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			Optional<Stock> optional = iStockService.queryById(id);
			if (optional.isPresent()) {
				mav.addObject("stock", optional.get());
			}
		}
		mav.setViewName("/back/stock/edit");
		return mav;
	}
	
	/**
	 * 保存产品库存
	 * 
	 * @param stock 产品库存模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(Stock stock) {
		boolean success = iStockService.saveOrUpdate(stock);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 删除产品库存
	 * 
	 * @param id 产品库存Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iStockService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的产品库存Id参数有误！");
	}

}
