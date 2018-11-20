package cn.com.lhd.core.converter;

import org.springframework.core.convert.converter.Converter;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.html.HtmlEscapers;

import cn.com.lhd.core.utils.BlankUtil;

public abstract class AbstractConverter<T> implements Converter<String, T> {

	// 是否处理html特殊标识
	private boolean escapeHtml = false;
	
	// 是否处理两端的空白
	private boolean trimContent = true;
	
	// 是否过滤忽略空白
	private boolean convertWhitespaceToNull = true;

	@Override
	public T convert(String source) {
		String thisParse = source;
		if (!BlankUtil.isBlank(thisParse)) {
			thisParse = trimContent ? CharMatcher.whitespace().trimFrom(thisParse) : thisParse;
			if (!Strings.isNullOrEmpty(thisParse)) {
				if (escapeHtml) {
					thisParse = HtmlEscapers.htmlEscaper().escape(thisParse);
				}
			} else if (convertWhitespaceToNull) {
				return null;
			}
		}
		return convertAfterCheck(thisParse);
	}

	public abstract T convertAfterCheck(String source);

	public void setEscapeHtml(boolean escapeHtml) {
		this.escapeHtml = escapeHtml;
	}

	public void setTrimContent(boolean trimContent) {
		this.trimContent = trimContent;
	}

	public void setConvertWhitespaceToNull(boolean convertWhitespaceToNull) {
		this.convertWhitespaceToNull = convertWhitespaceToNull;
	}

	public boolean isEscapeHtml() {
		return escapeHtml;
	}

	public boolean isTrimContent() {
		return trimContent;
	}

	public boolean isConvertWhitespaceToNull() {
		return convertWhitespaceToNull;
	}
}
