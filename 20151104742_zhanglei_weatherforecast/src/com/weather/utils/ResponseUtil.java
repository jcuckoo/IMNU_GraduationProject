package com.weather.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**  
 响应工具类   
*/
public class ResponseUtil {
	
	public static void write(HttpServletResponse response, String str) throws Exception{
		PrintWriter pw = response.getWriter();
		pw.write(str);
		pw.flush();
		pw.close();
	}

}
