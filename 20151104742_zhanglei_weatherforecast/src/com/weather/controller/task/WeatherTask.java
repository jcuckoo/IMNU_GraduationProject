package com.weather.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import com.weather.entity.City;
import com.weather.entity.Weather;
import com.weather.service.ICityService;
import com.weather.service.IWeatherService;
import com.weather.utils.WeatherUtil;

// 刷新天气数据定时器

public class WeatherTask {
	
	@Autowired
	private IWeatherService iWeatherService;
	
	@Autowired
	private ICityService iCityService;
	
	public List<Weather> parseWeatherInfo(String location){
		String jsonStr = WeatherUtil.getJsonInfoByLocation(location);
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
		jsonObject = JSON.parseObject(jsonArray.getString(0));
		String status = jsonObject.getString("status");
		List<Weather> wList = Lists.newLinkedList();
		if (status.toString().equals("ok")) {
			JSONObject basic = jsonObject.getJSONObject("basic");
			// 地址
			String address = basic.getString("location");
			Weather weather = new Weather();
			weather.setCityName(address);
			if (iWeatherService.queryCount(weather, false) > 0) {
				wList = iWeatherService.queryList(weather, false, null, null, null);
			} else {
				JSONArray daily_forecast = jsonObject.getJSONArray("daily_forecast");
				for (int i = 0; i < daily_forecast.size(); i++) {
					jsonObject = JSON.parseObject(daily_forecast.getString(i));
					// 日期
					String date = jsonObject.getString("date");
					// 最高温度
					String tmp_max = jsonObject.getString("tmp_max");
					// 最低温度
					String tmp_min = jsonObject.getString("tmp_min");
					// 白天天气状况描述
					String cond_txt_d = jsonObject.getString("cond_txt_d");
					// 晚上天气状况描述
					String cond_txt_n = jsonObject.getString("cond_txt_n");
					// 风向
					String wind_dir = jsonObject.getString("wind_dir");
					// 风力
					String wind_sc = jsonObject.getString("wind_sc");
					// 相对湿度
					String hum = jsonObject.getString("hum");
					// 降水量
					String pcpn = jsonObject.getString("pcpn");
					// 能见度，单位：公里
					String vis = jsonObject.getString("vis");
					weather = new Weather();
					// 向数据库插入数据
					if (cond_txt_d.contains("晴") || cond_txt_d.contains("多云")) {
						weather.setState(0);
					} else if (cond_txt_d.contains("雨") || cond_txt_d.contains("阴")) {
						weather.setState(1);
					} else if (cond_txt_d.contains("雪")) {
						weather.setState(2);
					} else if (cond_txt_d.contains("电")) {
						weather.setState(3);
					}
					weather.setCityName(location);
					weather.setDate(date);
					weather.setTmpMax(Integer.valueOf(tmp_max));
					weather.setTmpMin(Integer.valueOf(tmp_min));
					weather.setCondTxtD(cond_txt_d);
					weather.setCondTxtN(cond_txt_n);
					weather.setWindDir(wind_dir);
					weather.setWindSc(wind_sc);
					weather.setHum(hum);
					weather.setPcpn(pcpn);
					weather.setVis(vis);
					iWeatherService.save(weather);
					wList.add(weather);
				}
			}
		}
		return wList;
	}
	
	public void doTask(){
		// 清空所有数据
		iWeatherService.deleteAll();
		
		// 查询系统中存在的城市，然后添加其对应的天气信息
		List<City> cityList = iCityService.queryList(null, null, null, null);
		for (City city : cityList) {
			parseWeatherInfo(city.getName());
		}
	}
	
	public static void main(String[] args) {
		String str = "小雨";
		System.out.println(str.contains("雨"));
	}
	
}
