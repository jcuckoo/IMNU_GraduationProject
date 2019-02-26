package cn.com.lhd.web.controller;

import org.apache.shiro.SecurityUtils;

import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.page.PageBeanVO;
import cn.com.lhd.web.utils.SysProperties;

/**
 *
 * @desc 公共控制器
 *
 */
public class CommonController extends BaseController {

    /**
     * 每页容量默认为10
     */
    protected static final int pageSize = 10;
    
    /**
     * 用户类型
     */
    protected static final String USERTYPE_M = "管理员";
    protected static final String USERTYPE_C = "普通用户";
    protected static final String USERTYPE_V = "VIP用户";

    /**
     * 组装分页信息
     *
     * @param pageNo 页号
     * @param dataCount 结果集
     */
    public void createPageVo(int pageNo, int pageSize, int dataCount){
        PageBeanVO pageBeanVo = new PageBeanVO();
        pageBeanVo.setPageSize(pageSize);
        pageBeanVo.setCurrentPage(pageNo);
        pageBeanVo.calculate(dataCount);
        httpRequest.setAttribute(SysProperties.PAGEBEAN_VO, pageBeanVo);
    }
    
    /**
     * 获取用户ID
     * @return
     */
    public User getCurrentUser(){
    	return (User) SecurityUtils.getSubject().getSession().getAttribute(SysProperties.CURRENTUSER);
    }

}
