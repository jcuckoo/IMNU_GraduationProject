package com.weather.utils;

public interface SysProperties {
	
	/**
	 * 分页
	 */
	public static final String PAGEBEAN_VO = "pageBeanVo";
	
	/**
	 * 当前用户
	 */
	public static final String CURRENTUSER = "currentUser";
	
	/**
     * 用户角色
     */
    public static final String USERTYPE_M = "管理员";
    public static final Long USERTYPE_M_ID = 1L;
    public static final String USERTYPE_T = "教师";
    public static final Long USERTYPE_T_ID = 2L;
	
}
