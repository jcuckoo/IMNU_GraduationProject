package cn.com.lhd.web.controller.fore;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.entity.FilmType;
import cn.com.lhd.web.service.IFilmService;
import cn.com.lhd.web.service.IFilmTypeService;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.PageUtil;

/**
 * 
 * @desc 影视库前端控制器
 *
 */
@Controller
@RequestMapping(value = "/film")
public class FilmForeController extends CommonController {

	@Autowired
	private IFilmTypeService iFilmTypeService;

	@Autowired
	private IFilmService iFilmService;
	
	/**
	 * 影视库
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Film film, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		film.setStatus(1);
		int totalCount = iFilmService.queryCount(film);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Film> filmList = totalCount == 0 ? Collections.EMPTY_LIST
				: iFilmService.queryList(film, null, sortSet, page);
		sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<FilmType> filmTypeList = iFilmTypeService.queryList(null, null, sortSet, null);
		StringBuffer param = new StringBuffer();
		ModelAndView mav = new ModelAndView();
		if (!BlankUtil.isBlank(film.getTitle())) {
			param.append("name=" + film.getTitle() + "&");
		}
		if (Objects.nonNull(film.getFilmType()) && Objects.nonNull(film.getFilmType().getId())) {
			param.append("filmType.id=" + film.getFilmType().getId() + "&");
		}
		mav.addObject("pageCode", PageUtil.genPagination(httpRequest.getContextPath() + "/film/list.html", totalCount,
				pageNo, pageSize, param.toString()));
		mav.addObject("filmTypeList", filmTypeList);
		mav.addObject("datalist", filmList);
		mav.addObject("pageTitle", "影视库库-滨海影视网");
		mav.addObject("navTitle", "首页  &gt;&gt; 影视库");
		mav.addObject("mainPage", "/pages/fore/film/default.jsp");
		mav.setViewName("/fore/film/index");
		return mav;
	}
	
	/**
	 * 
	 * 
	 * @param id 
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		Film film = iFilmService.queryById(id);
		if (!BlankUtil.isBlank(film)) {
			mav.addObject("film", film);
			// 预览次数加1
			Film vo = new Film();
			vo.setId(id);
			vo.setClickCount(film.getClickCount() + 1);
			iFilmService.saveOrUpdate(vo);
		}
		mav.addObject("pageTitle", "电影详情-滨海影视网");
		mav.addObject("navTitle", "首页  &gt;&gt; 电影详情");
		mav.addObject("mainPage", "/pages/fore/film/view.jsp");
		mav.setViewName("/fore/film/index");
		return mav;
	}
	
}
