package cn.com.lhd.web.controller.fore;

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
import cn.com.lhd.core.utils.BlankUtil;
import cn.com.lhd.core.utils.PageUtil;
import cn.com.lhd.core.utils.SysProperties;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Code;
import cn.com.lhd.web.entity.CodeType;
import cn.com.lhd.web.entity.Message;
import cn.com.lhd.web.entity.Photo;
import cn.com.lhd.web.service.IMessageService;

/**
 *
 * @desc 留言前端控制器
 * 
 * @author luohaidian
 * @date 2018年11月7日
 * @time 下午1:40:33
 */
@Controller
@RequestMapping(value = "/message")
public class MessageForeController extends CommonController {

	@Autowired
	private IMessageService iMessageService;

	/**
	 * 留言页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iMessageService.queryCount(null);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Message> messageList = totalCount == 0 ? Collections.EMPTY_LIST
				: iMessageService.queryList(null, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", messageList);
		mav.addObject("pageCode", PageUtil.genPagination(httpRequest.getContextPath() + "/message/list.html", totalCount,
				pageNo, pageSize, null));
		mav.addObject("pageTitle", "留言板-个人博客系统");
		mav.addObject("mainPage", "/pages/fore/message/default.jsp");
		mav.setViewName("/fore/message/index");
		return mav;
	}

	/**
	 * 保存留言
	 * 
	 * @param message
	 *            留言实体模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(Message message) {
		message.setContent(BlankUtil.Html2Text(message.getContent()));
		message.setEmail(getCurrentUser().getEmail());
		message.setMobile(getCurrentUser().getMobile());
		message.setUsername(getCurrentUser().getUsername());
		message.setTruename(getCurrentUser().getName());
		boolean success = iMessageService.save(message);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}

}
