package cn.com.lhd.web.utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @desc 字符串/对象工具类
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:07:03
 */
public class BlankUtil {

	public static boolean isBlank(final String str) {
		return (str == null) || (str.trim().length() <= 0 || str.equals(""));
	}

	public static boolean isBlank(final Character cha) {
		return (cha == null) || cha.equals(' ');
	}

	public static boolean isBlank(final Object obj) {
		return (obj == null);
	}

	public static boolean isBlank(final Object[] objs) {
		return (objs == null) || (objs.length <= 0);
	}

	public static boolean isBlank(final Collection<Object> obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	public static boolean isBlank(final Set<Object> obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	public static boolean isBlank(final Serializable obj) {
		return obj == null;
	}

	public static boolean isBlank(final Map<Object, Object> obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 过滤任意script,html,style标签
	 * 
	 * @param str
	 * @return
	 */
	public static String Html2Text(String str) {
		String htmlStr = str; // 含html标签的字符串
		String textStr = "";
		try {
			// 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			// 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			// 定义HTML标签的正则表达式
			String regEx_html = "<[^>]+>";

			Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			Matcher m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			Matcher m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			Matcher m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}
	
	public static void main(String[] args) {
		String str = "<div><img src='abc.png'>1111</div>";
		System.out.println(Html2Text(str));
	}

}
