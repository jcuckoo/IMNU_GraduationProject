package cn.com.lhd.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @desc 时间处理工具类
 * 
 */
public class DateUtil {
	
	/**
	 * 格式化当前时间为指定的字符串
	 * @return
	 */
	public static String formatCurrentDate(String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	/**
     * 将日期类型转换成指定格式的日期字符串
     *
     * @param date
     *            待转换的日期
     * @param dateFormat
     *            日期格式字符串
     * @return
     */
    public static String convertDateToStr(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

	/**
	* 获取当前日期是星期几
	*
	* @param dt
	* @return 当前日期是星期几
	*/
	public static String getWeekOfDate(Date date) {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
	
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	public static void main(String[] args) {
		System.out.println(getWeekOfDate(new Date()));
	}

}
