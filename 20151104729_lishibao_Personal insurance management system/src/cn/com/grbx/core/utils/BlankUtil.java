package cn.com.lhd.core.utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 字符串/对象工具类
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

}
