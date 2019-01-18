package cn.com.lhd.web.page;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @desc 自定义分页标签
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:39:19
 */
public class PageBeanVO {

	private long currentPage = 1L; // 当前页
	private long totalPages = 0L; // 总页数
	private long pageSize = 10L; // 一页多少行
	private long totalRows = 0L; // 总行数
	private long pageStartRow = 0L; // 第一页
	private long pageEndRow; // 最后一页
	private boolean hasNextPage = false; // 下一页
	private boolean hasPreviousPage = false;// 上一页
	private Collection<Object> dataList;
	private Map<Object, Object> dateMap; // 用于包装用户的MAP对象

	public PageBeanVO() {
	}

	public PageBeanVO(long pageSize, long currentPage) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public void calculate(long MaxRowCount) {
		if (this.currentPage < 1L) {
			this.currentPage = 1L;
		}
		if (this.pageSize < 1L) {
			this.pageSize = 10L;
		}
		this.totalRows = MaxRowCount; // 总行数
		if (this.totalRows % this.pageSize == 0L) {
			this.totalPages = (this.totalRows / this.pageSize); // 得到总页数
		} else {
			this.totalPages = (this.totalRows / this.pageSize + 1L);
		}
		if (this.currentPage > this.totalPages) {
			this.currentPage = this.totalPages;
		}
		if (this.currentPage >= this.totalPages) {
			this.hasNextPage = false;
		} else {
			this.hasNextPage = true;
		}
		if ((this.currentPage <= 1L) || (this.totalPages == 0L)) {
			this.hasPreviousPage = false;
		} else {
			this.hasPreviousPage = true;
		}
		this.pageStartRow = ((this.currentPage - 1L) * this.pageSize);
		if (this.pageStartRow < 0L) {
			this.pageStartRow = 0L;
		}
		this.pageEndRow = (this.currentPage * this.pageSize);
		if (this.pageEndRow > this.totalRows)
			this.pageEndRow = this.totalRows;
	}

	public Collection<Object> getDataList() {
		return this.dataList;
	}

	public long getCurrentPage() {
		return this.currentPage;
	}

	public boolean isHasNextPage() {
		return this.hasNextPage;
	}

	public boolean isHasPreviousPage() {
		return this.hasPreviousPage;
	}

	public long getPageEndRow() {
		return this.pageEndRow;
	}

	public long getPageSize() {
		return this.pageSize;
	}

	public long getTotalPages() {
		return this.totalPages;
	}

	public long getPageStartRow() {
		return this.pageStartRow;
	}

	public long getTotalRows() {
		return this.totalRows;
	}

	public String getDescribe() {
		return describe();
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public void setPageStartRow(long pageStartRow) {
		this.pageStartRow = pageStartRow;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageEndRow(long pageEndRow) {
		this.pageEndRow = pageEndRow;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public void setDataList(Collection<Object> dataList) {
		this.dataList = dataList;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("currentPage=").append(this.currentPage).append(",").append("totalPages=").append(this.totalPages)
				.append(",").append("pageSize=").append(this.pageSize).append(",").append("totalRows=")
				.append(this.totalRows).append(",").append("pageStartRow=").append(this.pageStartRow).append(",")
				.append("pageEndRow=").append(this.pageEndRow).append(",").append("hasNextPage=")
				.append(this.hasNextPage).append(",").append("currentPage=").append(this.currentPage).append(",")
				.append("hasPreviousPage=").append(this.hasPreviousPage);

		return sb.toString();
	}

	public String describe() {
		return "";
	}

	public Map<Object, Object> getDateMap() {
		return dateMap;
	}

	public void setDateMap(Map<Object, Object> dateMap) {
		this.dateMap = dateMap;
	}

}
