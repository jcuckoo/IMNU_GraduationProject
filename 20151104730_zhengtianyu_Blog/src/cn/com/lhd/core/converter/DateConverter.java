package cn.com.lhd.core.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.google.common.base.Strings;

/**  
* @desc    
*  
* @author luohaidian
* @date 2018年10月4日  
* @time 下午6:32:59
*/
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (Strings.isNullOrEmpty(source)) {
			return null;
		}
        //实现将字符串转成日期类型(格式是yyyy-MM-dd)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果参数绑定失败返回null
        return null;
	}

}
