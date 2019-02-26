package cn.com.lhd.web.controller.back;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.entity.FilmType;
import cn.com.lhd.web.service.IFilmService;
import cn.com.lhd.web.service.IFilmTypeService;
import cn.com.lhd.web.utils.BlankUtil;

/**
 *
 * @desc 电影管理前端控制器
 *
 */
@Controller
@RequestMapping(value = "/manage/film")
public class FilmBackController extends CommonController {
	
	@Autowired
	private IFilmService iFilmService;
	
	@Autowired
	private IFilmTypeService iFilmTypeService;
	
	/**
	 * 电影列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<FilmType> filmTypeList = iFilmTypeService.queryList(null, null, sortSet, null);
		mav.addObject("filmTypeList", filmTypeList);
		mav.setViewName("/back/film/list");
		return mav;
	}
	
	/**
	 * 电影列表
	 * 
	 * @param film 电影模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(Film film, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		if (!getCurrentUser().getUserType().equals(USERTYPE_M)) {
			film.setCreator(getCurrentUser());
		}
		int totalCount = iFilmService.queryCount(film);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<Film> filmList = totalCount == 0 ? Collections.EMPTY_LIST
				: iFilmService.queryList(film, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", filmList);
		mav.setViewName("/back/film/contextlist");
		return mav;
	}
	
	/**
	 * 新增/编辑页
	 * 
	 * @param id 电影Id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			Film film = iFilmService.queryById(id);
			if (!BlankUtil.isBlank(film)) {
				mav.addObject("film", film);
			}
		}
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		List<FilmType> filmTypeList = iFilmTypeService.queryList(null, null, sortSet, null);
		mav.addObject("filmTypeList", filmTypeList);
		mav.setViewName("/back/film/edit");
		return mav;
	}
	
	/**
	 * 保存
	 * 
	 * @param film 电影模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(Film film) {
		if (BlankUtil.isBlank(film.getId())) {
			film.setCreator(getCurrentUser());
		}
		String contentNoTag = BlankUtil.Html2Text(film.getContent());
		String summary = contentNoTag.length() > 80 ? contentNoTag.substring(0, 80) : contentNoTag;
		film.setSummary(summary);
		film.setStatus(0);
		boolean success = iFilmService.saveOrUpdate(film);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	/**
	 * 电影详情
	 * 
	 * @param id 电影Id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			Film film = iFilmService.queryById(id);
			if (!BlankUtil.isBlank(film)) {
				mav.addObject("film", film);
			}
		}
		mav.setViewName("/back/film/view");
		return mav;
	}
	
	/**
	 * 删除电影
	 * 
	 * @param id 电影Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iFilmService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的电影Id参数有误！");
	}
	
	/**
	 * 视频文件上传页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uploadPage")
	public ModelAndView uploadPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/film/upload");
		return mav;
	}
	
	/**
	 * 审核电影
	 * 
	 * @param id 电影Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/push")
	public JsonViewData push(Long id) {
		if (Objects.nonNull(id)) {
			Film loadFilm = iFilmService.queryById(id);
			if (BlankUtil.isBlank(loadFilm)) {
				return setJsonViewData(ResultCode.FAIL, "传递的电影Id参数有误！");
			}
			Film film = new Film();
			film.setId(id);
			film.setStatus(1);
			boolean success = iFilmService.saveOrUpdate(film);
			return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
		}
		return setJsonViewData(ResultCode.FAIL, "传递的电影Id参数有误！");
	}
	
}
