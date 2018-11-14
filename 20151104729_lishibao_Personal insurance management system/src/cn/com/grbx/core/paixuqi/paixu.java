package cn.com.grbx.core.paixuqi;

import cn.com.lhd.core.ISort;

/**
 * 排序器
 */
public class paixu implements ISort {

	private String field;

	private boolean asc = true;

	public paixu() {
		super();
	}

	public paixu(String field) {
		this();
		this.field = field;
	}

	public paixu(String field, boolean asc) {
		this(field);
		this.asc = asc;
	}

	@Override
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}
}
