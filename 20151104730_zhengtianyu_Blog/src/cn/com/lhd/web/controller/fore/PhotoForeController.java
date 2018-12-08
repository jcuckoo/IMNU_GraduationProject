package cn.com.lhd.web.controller.fore;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;

import cn.com.lhd.core.ISort;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.core.utils.SysProperties;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.entity.Code;
import cn.com.lhd.web.entity.CodeType;
import cn.com.lhd.web.entity.Photo;
import cn.com.lhd.web.service.ICodeService;
import cn.com.lhd.web.service.IPhotoService;

/**  
* @desc 相册前端控制器   
*  
* @author luohaidian
* @date 2018年11月6日  
* @time 下午10:08:07
*/
@Controller
@RequestMapping(value = "/photo")
public class PhotoForeController extends CommonController {
	
	@Autowired
	private ICodeService iCodeService;
	
	@Autowired
	private IPhotoService iPhotoService;
	
	/**
	 * 相册列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		Code code = new Code();
		code.setCodeType(new CodeType(SysProperties.XCLX));
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", true));
		List<Code> codeList = iCodeService.queryList(code, null, sortSet, null);
		Photo photo = new Photo();
		Code codeVo = new Code();
		for (Code vo : codeList) {
			codeVo.setId(vo.getId());
			photo.setPhotoType(codeVo);
			int photoCount = iPhotoService.queryCount(photo);
			vo.setPhotoCount(photoCount);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("codeList", codeList);
		mav.addObject("pageTitle", "博主相册-个人博客系统");
		mav.addObject("mainPage", "/pages/fore/photo/default.jsp");
		mav.setViewName("/fore/photo/index");
		return mav;
	}
	
	/**
	 * 相册详情
	 * 
	 * @param id 相册类别Id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView();
		Optional<Code> optional = iCodeService.queryById(id);
		if (optional.isPresent()) {
			mav.addObject("code", optional.get());
		}
		Photo photo = new Photo();
		// 只能看开放照片
		photo.setState(0);
		photo.setPhotoType(new Code(id));
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		List<Photo> photoList = iPhotoService.queryList(photo, null, sortSet, null);
		mav.addObject("photoList", photoList);
		mav.addObject("pageTitle", "博主相册-个人博客系统");
		mav.addObject("mainPage", "/pages/fore/photo/view.jsp");
		mav.setViewName("/fore/photo/index");
		return mav;
	}

}
