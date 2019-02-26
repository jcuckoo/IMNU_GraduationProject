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
import cn.com.lhd.web.entity.Role;
import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.service.IUserService;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.CryptographyUtil;

/**
 * 
 * @desc 用户管理前端控制器
 *
 */
@Controller
@RequestMapping(value = "/manage/user")
public class UserBackController extends CommonController {

	@Autowired
	private IUserService iUserService;
	
	/**
	 * 用户列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/user/list");
		return mav;
	}

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public JsonViewData save(User user) {
		boolean success = iUserService.saveOrUpdate(user);
		return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
	}

	/**
	 * 修改密码页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toupdatepwd")
	public ModelAndView toUpdatePwd() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", getCurrentUser());
		mav.setViewName("/back/user/editPwd");
		return mav;
	}

	/**
	 * 更新密码
	 * 
	 * @param user 用户模型
	 * @param newpassword 新密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatepwd")
	public JsonViewData updatepwd(User user, @RequestParam(value = "newPassword") String newPassword) {
		Long userId = user.getId();
		User loadUser = iUserService.queryById(userId);
		if (!BlankUtil.isBlank(loadUser)) {
			if (!CryptographyUtil.md5(user.getPassword(), CryptographyUtil.SALT).equals(loadUser.getPassword())) {
				return setJsonViewData(ResultCode.PARAM_ERROR, "原密码输入有误！");
			}
			if (CryptographyUtil.md5(newPassword, CryptographyUtil.SALT).equals(loadUser.getPassword())) {
				return setJsonViewData(ResultCode.PARAM_ERROR, "新密码不能与原密码一致！");
			}
			User userVo = new User();
			userVo.setId(userId);
			userVo.setPassword(CryptographyUtil.md5(newPassword, CryptographyUtil.SALT));
			boolean success = iUserService.saveOrUpdate(userVo);
			return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL);
		}
		return setJsonViewData(ResultCode.NO_EXISTS);
	}

	/**
	 * 用户列表
	 * 
	 * @param user
	 *            用户模型
	 * @param pageNo
	 *            页号
	 * @return
	 */
	@RequestMapping(value = "/contextlist")
	public ModelAndView contextList(User user, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		int totalCount = iUserService.queryCount(user);
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("create_time", false));
		IPage page = new SimplePage(pageNo, pageSize);
		List<User> userList = totalCount == 0 ? Collections.EMPTY_LIST
				: iUserService.queryList(user, null, sortSet, page);
		this.createPageVo(pageNo, pageSize, totalCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("datalist", userList);
		mav.setViewName("/back/user/contextlist");
		return mav;
	}

	/**
	 * 编辑用户信息
	 * 
	 * @param id
	 *            用户Id
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			User loadUser = iUserService.queryById(id);
			if (!BlankUtil.isBlank(loadUser)) {
				mav.addObject("user", loadUser);
			}
		}
		mav.setViewName("/back/user/edit");
		return mav;
	}

	/**
	 * 查看用户详情
	 * 
	 * @param id
	 *            用户Id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		if (Objects.nonNull(id)) {
			User loadUser = iUserService.queryById(id);
			if (!BlankUtil.isBlank(loadUser)) {
				mav.addObject("user", loadUser);
			}
		}
		mav.setViewName("/back/user/view");
		return mav;
	}

	/**
	 * 根据Id删除用户
	 * 
	 * @param id
	 *            用户Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(Long id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iUserService.delete(id);
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的用户Id参数有误！");
	}
	
	/**
	 * 升级为VIP用户
	 * 
	 * @param id 用户Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/push")
	public JsonViewData push(Long id) {
		if (Objects.nonNull(id)) {
			User loadUser = iUserService.queryById(id);
			if (BlankUtil.isBlank(loadUser)) {
				return setJsonViewData(ResultCode.FAIL, "传递的用户Id参数有误！");
			}
			User user = new User();
			user.setId(id);
			user.setUserType(USERTYPE_V);
			user.setUserRole(new Role(3L));
			boolean success = iUserService.saveOrUpdate(user);
			return success ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "升级VIP失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "传递的用户Id参数有误！");
	}

}
