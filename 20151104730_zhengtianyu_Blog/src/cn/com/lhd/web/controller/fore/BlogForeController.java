package cn.com.lhd.web.controller.fore;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.core.utils.BlankUtil;
import cn.com.lhd.core.utils.PageUtil;
import cn.com.lhd.core.utils.SysProperties;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Blog;
import cn.com.lhd.web.entity.Code;
import cn.com.lhd.web.entity.CodeType;
import cn.com.lhd.web.service.IBlogService;
import cn.com.lhd.web.service.ICodeService;

/**
*
* @desc 博客文章前端控制器
* 
* @author luohaidian
* @date 2018年11月6日
* @time 下午3:46:43
*/
@Controller
@RequestMapping(value = "/article")
public class BlogForeController extends CommonController {
	
	@Autowired
	private IBlogService iBlogService;
	
	@Autowired
	private ICodeService iCodeService;
	
	/**
	 * 博客文章列表
	 * 
	 * @param blog 博客文章模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Blog blog, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		ModelAndView mav = new ModelAndView();
		int totalCount = iBlogService.queryCount(blog);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false), new Sorter("click_count", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Blog> blogList = totalCount == 0 ? Collections.EMPTY_LIST
				: iBlogService.queryList(blog, null, sortSet, page);
		mav.addObject("datalist", blogList);
		StringBuffer param = new StringBuffer();
		if (Objects.nonNull(blog.getBlogType()) && Objects.nonNull(blog.getBlogType().getId())) {
			param.append("&blogType.id=" + blog.getBlogType().getId());
		}
		mav.addObject("pageCode", PageUtil.genPagination(httpRequest.getContextPath() + "/article/list.html", totalCount,
				pageNo, pageSize, param.toString()));
		mav.addObject("pageTitle", "文章列表-个人博客系统");
		mav.addObject("mainPage", "/pages/fore/blog/default.jsp");
		mav.setViewName("/fore/blog/index");
		return mav;
	}
	
	/**
	 * 博客文章详情
	 * 
	 * @param id 博客文章Id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			Optional<Blog> optional = iBlogService.queryById(id);
			if (optional.isPresent()) {
				Blog blog = optional.get();
				mav.addObject("blog", blog);
				// 浏览次数加1
				Blog vo = new Blog();
				vo.setId(id);
				vo.setClickCount(blog.getClickCount() + 1);
				iBlogService.saveOrUpdate(vo);
			}
		}
		mav.addObject("pageTitle", "文章详情-个人博客系统");
		mav.setViewName("/fore/blog/view");
		return mav;
	}
	
	/**
	 * 搜索
	 * 
	 * @param blog 博客模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/search")
	public ModelAndView search(Blog blog, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		ModelAndView mav = new ModelAndView();
		Code code = new Code();
		code.setCodeType(new CodeType(SysProperties.BKLX));
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<Code> codeList = iCodeService.queryList(code, null, sortSet, null);
		mav.addObject("codeList", codeList);
		int totalCount = iBlogService.queryCount(blog);
		sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Blog> blogList = totalCount == 0 ? Collections.EMPTY_LIST
				: iBlogService.queryList(blog, null, sortSet, page);
		mav.addObject("datalist", blogList);
		StringBuffer param = new StringBuffer();
		if (Objects.nonNull(blog.getBlogType()) && Objects.nonNull(blog.getBlogType().getId())) {
			param.append("&blogType.id=" + blog.getBlogType().getId());
		}
		if (BlankUtil.isBlank(blog.getTitle())) {
			param.append("&title=" + blog.getTitle());
		}
		mav.addObject("pageCode", PageUtil.genPagination(httpRequest.getContextPath() + "/article/search.html", totalCount,
				pageNo, pageSize, param.toString()));
		mav.addObject("pageTitle", "搜索文章-个人博客系统");
		mav.setViewName("/fore/blog/search");
		return mav;
	}

}
