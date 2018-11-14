package com.ziye.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class weather {
	private static final String API_KEY = "e360cc946a1e426bbda2cb07104ec84c";//用户key值
	
	public static String getResult(String city) {
		String result="";
		String weatherurl = "https://free-api.heweather.com/s6/weather/now?location="+city+"&key="+API_KEY;//请求地址
		try {
			URL url = new URL(weatherurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();//打开链接
			InputStream in = connection.getInputStream();//字节流的   获取数据流
			InputStreamReader is = new InputStreamReader(in,"UTF-8");//转为字符流
			BufferedReader br = new BufferedReader(is);
			String temp = br.readLine();
			for(int i=0;i<=temp.length();i++) {
				result = temp;
			}
//			while ((temp=br.readLine())!=null) {
//				result = temp;
//				
//				
//			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
		public static void main(String[] args) {
//		String city="";
//		Scanner scanner = new Scanner();
//		System.out.println("请输入城市名：");
//		city = scanner.toString();
		String result = getResult("beijing");
		System.out.println(result);
		
	}
}