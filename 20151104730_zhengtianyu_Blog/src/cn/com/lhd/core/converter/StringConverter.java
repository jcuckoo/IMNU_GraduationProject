package cn.com.lhd.core.converter;

import cn.com.lhd.core.converter.AbstractConverter;

/**
 *
 * @author luohaidian
 * @date 2018年7月16日
 * @time 上午10:09:29
 */
public class StringConverter extends AbstractConverter<String> {

	@Override
	public String convertAfterCheck(String source) {
		return source;
	}
}
