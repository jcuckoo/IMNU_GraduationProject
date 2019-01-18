package cn.com.lhd.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @desc 时间处理工具类
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:07:24
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
     * 获取之后的amount年
     * 
     * @param amount
     * @return
     */
    public static Date getAfferYear(int amount){
    	Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); //设置起时间
        cal.add(Calendar.YEAR, amount); //增加amount年
    	return cal.getTime();
    }
    
}
