package com.weather.utils;

/**
 分页工具类
 */
public class PageUtil {

	/**
	 * 生成分页代码
	 * 
	 * @param targetUrl
	 *            目标地址
	 * @param totalNum
	 *            总记录数
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public static String genPagination(String targetUrl, long totalNum, int currentPage, int pageSize, String param) {
		long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		if (totalPage == 0) {
			return "<p style='font-size:15px;color:#666;'>未查询到数据</p>";
		} else {
			StringBuffer pageCode = new StringBuffer();
			pageCode.append("<a href='" + targetUrl + "?pageNo=1&" + param + "'>首页</a>");
			if (currentPage > 1) {
				pageCode.append("<a href='" + targetUrl + "?pageNo=" + (currentPage - 1) + "&" + param + "'>上一页</a>");
			} else {
				pageCode.append("<span class='disabled'>上一页</span>");
			}
			for (int i = currentPage - 2; i <= currentPage + 2; i++) {
				if (i < 1 || i > totalPage) {
					continue;
				}
				if (i == currentPage) {
					pageCode.append("<span class='current'>" + i + "</span>");
				} else {
					pageCode.append("<a href='" + targetUrl + "?pageNo=" + i + "&" + param + "'>" + i + "</a>");
				}
			}
			if (currentPage < totalPage) {
				pageCode.append("<a href='" + targetUrl + "?pageNo=" + (currentPage + 1) + "&" + param + "'>下一页</a>");
			} else {
				pageCode.append("<span class='disabled'>下一页</span>");
			}
			pageCode.append("<a href='" + targetUrl + "?pageNo=" + totalPage + "&" + param + "'>尾页</a>");
			pageCode.append("&nbsp;&nbsp;第" + currentPage + "页/共 "+ totalPage +" 页"); 
			return pageCode.toString();
		}
	}
	
}
