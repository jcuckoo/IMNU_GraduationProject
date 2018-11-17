package com.weather.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

//获取天气数据接口
public class WeatherUtil {
	
	public static String getJsonInfoByLocation(String location){
		//参数字符串，如果拼接在请求链接之后，需要对中文进行 URLEncode   字符集 UTF-8
		// String key = "e360cc946a1e426bbda2cb07104ec84c";
	    StringBuffer param = new StringBuffer("key=e360cc946a1e426bbda2cb07104ec84c&");
	    param.append("location=" + location + "&");
	    StringBuilder sb = new StringBuilder();
	    InputStream is = null;
	    BufferedReader br = null;
	    PrintWriter out = null;
	    try {
	        //接口地址
	        String url = "https://free-api.heweather.com/s6/weather/forecast";
	        URL uri = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setReadTimeout(5000);
	        connection.setConnectTimeout(10000);
	        connection.setRequestProperty("accept", "*/*");
	        //发送参数
	        connection.setDoOutput(true);
	        out = new PrintWriter(connection.getOutputStream());
	        out.print(param);
	        out.flush();
	        //接收结果
	        is = connection.getInputStream();
	        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String line;
	        //缓冲逐行读取
	        while ( ( line = br.readLine() ) != null ) {
	            sb.append(line);
	        }
	    } catch ( Exception ignored ) {
	    	
	    } finally {
	        //关闭流
	        try {
	            if(is!=null){
	                is.close();
	            }
	            if(br!=null){
	                br.close();
	            }
	            if (out!=null){
	                out.close();
	            }
	        } catch ( Exception ignored ) {}
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		String location = "广州市";
		System.out.println(getJsonInfoByLocation(location));
	}

}
