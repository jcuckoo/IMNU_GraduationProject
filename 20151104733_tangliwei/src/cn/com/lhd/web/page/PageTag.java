package cn.com.lhd.web.page;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import cn.com.lhd.web.utils.SysProperties;

/**
 *
 * @desc 自定义分页标签
 * 
 */
public class PageTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		try {
			PageBeanVO pb = (PageBeanVO) pageContext.getRequest().getAttribute(SysProperties.PAGEBEAN_VO);
			long currentPage = 0;
			long totalPages = 0;
			if (pb != null) {
				if (pb.getCurrentPage() <= 1) {
					currentPage = 1;
				} else {
					currentPage = pb.getCurrentPage();
				}
				totalPages = pb.getTotalPages();
			}

			StringBuffer sb = new StringBuffer(200);
			sb.append("<script language='JavaScript'>");
			sb.append("Query = encodeURI(encodeURI(Query));");
			sb.append("function gotoPage(page){createPageList(page);$('html,body').animate({scrollTop:0}, 10);}");
			sb.append("</script>");
			
			sb.append("<nav>");
			sb.append("<ul class='pagination'>");
			sb.append("<li><a href='javascript:void(0);' onclick='gotoPage(1)'>首页</a></li>");
			if (currentPage > 1) {
				sb.append("<li><a href='javascript:void(0);' onclick='gotoPage("+ (currentPage - 1) +")'>上一页</a></li>");
			} else {
				sb.append("<li class='disabled'><a href='javascript:void(0);'>上一页</a></li>");
			}
			for (long i = currentPage - 2; i <= currentPage + 2; i++) {
				if (i < 1 || i > totalPages) {
					continue;
				}
				if (i == currentPage) {
					sb.append("<li class='active'><a href='javascript:void(0);' onclick='gotoPage("+ i +")'>" + i + "</a></li>");
				} else {
					sb.append("<li><a href='javascript:void(0);' onclick='gotoPage("+ i +")'>" + i + "</a></li>");
				}
			}
			if (currentPage < totalPages) {
				sb.append("<li><a href='javascript:void(0);' onclick='gotoPage("+ (currentPage + 1) +")'>下一页</a></li>");
			} else {
				sb.append("<li class='disabled'><a href='#'>下一页</a></li>");
			}
			sb.append("<li><a href='javascript:void(0);' onclick='gotoPage("+ totalPages +")'>尾页</a></li>");
			sb.append("</ul>");
			sb.append("</nav>");
			if (totalPages > 1) {
				pageContext.getOut().print(sb.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

}
