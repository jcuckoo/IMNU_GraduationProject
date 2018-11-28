package cn.com.lhd.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
*
* @desc 时间处理工具类
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
	 * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
	 * 
	 * @param nowTime 当前时间
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
		if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
			return true;
		}
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 校验是否在签到时间内
	 * 
	 * @return
	 */
	public static boolean checkDate(){
		String format = "HH:mm";
		SimpleDateFormat sf = new SimpleDateFormat(format);
		String now = sf.format(new Date());
		try {
			Date nowTime = new SimpleDateFormat(format).parse(now);
			Date startTime = new SimpleDateFormat(format).parse("08:00");
			Date endTime = new SimpleDateFormat(format).parse("08:05");
			if (isEffectiveDate(nowTime, startTime, endTime)) {
				return true;
			} else {
				return false;
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return false;
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
