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
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.entity.FilmType;
import cn.com.lhd.web.service.IFilmService;
import cn.com.lhd.web.service.IFilmTypeService;
import cn.com.lhd.web.utils.BlankUtil;

/**
 *
 * @desc 电影类别管理前端控制器
 */
@Controller
@RequestMapping(value = "/manage/filmType")
public class FilmTypeBackController extends CommonController {
	
	@Autowired
	private IFilmService iFilmService;
	
	@Autowired
	private IFilmTypeService iFilmTypeService;
	
	/**
	 * 电影类别列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/filmType/list");
		return mav;
	}
	
	/**
	 * 电影类别列表
	 * 
	 * @param filmType 电影类别模型
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(FilmType filmType, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iFilmTypeService.queryCount(filmType);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<FilmType> filmTypeList = totalCount == 0 ? Collections.EMPTY_LIST
				: iFilmTypeService.queryList(filmType, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", filmTypeList);
		mav.setViewName("/back/filmType/contextlist");
		return mav;
	}
	
	/**
	 * 新增/编辑页
	 * 
	 * @param id 电影类别Id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			FilmType filmType = iFilmTypeService.queryById(id);
			if (!BlankUtil.isBlank(filmType)) {
				mav.addObject("filmType", filmType);
			}
		}
		mav.setViewName("/back/filmType/edit");
		return mav;
	}
	
	/**
	 * 保存
	 * 
	 * @param filmType 电影类别模型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(FilmType filmType) {
		boolean success = iFilmTypeService.saveOrUpdate(filmType);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}
	
	
	/**
	 * 删除电影类别
	 * 
	 * @param id 电影类别Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			FilmType filmType = new FilmType();
			filmType.setId(id);
			Film film = new Film();
			film.setFilmType(filmType);
			if (iFilmService.queryCount(film) > 0) {
				return setJsonViewData(ResultCode.FAIL, "该电影类别下存在电影信息，不能删除！");
			}
			boolean deleted = iFilmTypeService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的电影类别Id参数有误！");
	}
	
}
