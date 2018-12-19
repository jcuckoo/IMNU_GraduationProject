package com.weather.controller;

import org.apache.shiro.SecurityUtils;

import com.weather.entity.User;
import com.weather.page.PageBeanVO;
import com.weather.utils.SysProperties;


public class CommonController extends BaseController {

    /**
     * 每页容量默认为10
     */
    protected static final int pageSize = 10;
    
    /**
     * 用户角色
     */
    protected static final String USERTYPE_M = "管理员";
    protected static final String USERTYPE_C = "普通用户";
    
    /**
     * 组装分页信息
     *
     *  pageNo 页号
     *  dataCount 结果集
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
     *
     */
    public User getCurrentUser(){
    	return (User) SecurityUtils.getSubject().getSession().getAttribute(SysProperties.CURRENTUSER);
    }

}
