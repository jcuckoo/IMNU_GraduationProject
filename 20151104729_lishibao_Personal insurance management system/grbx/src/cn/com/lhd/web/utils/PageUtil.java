package cn.com.lhd.web.utils;

/**
 * 
 * @desc 分页工具类
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:08:12
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
			pageCode.append("<li><a href='" + targetUrl + "?pageNo=1&" + param + "'>首页</a></li>");
			if (currentPage > 1) {
				pageCode.append(
						"<li><a href='" + targetUrl + "?pageNo=" + (currentPage - 1) + "&" + param + "'>上一页</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a href='javascript:void(0);'>上一页</a></li>");
			}
			for (int i = currentPage - 2; i <= currentPage + 2; i++) {
				if (i < 1 || i > totalPage) {
					continue;
				}
				if (i == currentPage) {
					pageCode.append("<li class='active'><a href='" + targetUrl + "?pageNo=" + i + "&" + param + "'>" + i
							+ "</a></li>");
				} else {
					pageCode.append("<li><a href='" + targetUrl + "?pageNo=" + i + "&" + param + "'>" + i + "</a></li>");
				}
			}
			if (currentPage < totalPage) {
				pageCode.append(
						"<li><a href='" + targetUrl + "?pageNo=" + (currentPage + 1) + "&" + param + "'>下一页</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a href='javascript:void(0);'>下一页</a></li>");
			}
			pageCode.append("<li><a href='" + targetUrl + "?pageNo=" + totalPage + "&" + param + "'>尾页</a></li>");
			pageCode.append("<li><a href=javascript:void(0);>第" + currentPage + "页/共 "+ totalPage +" 页</a></li>");
			return pageCode.toString();
		}
	}
	
}
