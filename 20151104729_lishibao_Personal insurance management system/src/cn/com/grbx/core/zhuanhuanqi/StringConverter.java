package cn.com.lhd.core.converter;

import cn.com.lhd.core.converter.AbstractConverter;


public class StringConverter extends AbstractConverter<String> {

	@Override
	public String convertAfterCheck(String source) {
		return source;
	}
}
