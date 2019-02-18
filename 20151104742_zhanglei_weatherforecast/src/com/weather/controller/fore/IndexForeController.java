package com.weather.controller.fore;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import com.weather.controller.CommonController;
import com.weather.entity.City;
import com.weather.entity.Weather;
import com.weather.service.ICityService;
import com.weather.service.IWeatherService;
import com.weather.utils.BlankUtil;
import com.weather.utils.WeatherUtil;


@Controller
public class IndexForeController extends CommonController {
	
	@Autowired
	private IWeatherService iWeatherService;
	
	@Autowired
	private ICityService iCityService;
	
	/**
	 * 解析天气情况
	 * 
	 * @param location 城市名
	 * @return
	 */
	public List<Weather> parseWeatherInfo(String location){
		String jsonStr = WeatherUtil.getJsonInfoByLocation(location);
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
		jsonObject = JSON.parseObject(jsonArray.getString(0));
		String status = jsonObject.getString("status");
		List<Weather> wList = Lists.newLinkedList();
		if (status.toString().equals("ok")) {
			// JSONObject basic = jsonObject.getJSONObject("basic");
			// 地址
			Weather weather = new Weather();
			weather.setCityName(location);
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
	
	/**
	 * 前台首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		List<Weather> weatherList = Lists.newLinkedList();
		City city = iCityService.queryByRand();
		String cityName = city.getName();
		// 如果是登录后的普通用户，则查询自己所属的城市天气预报
		if (Objects.nonNull(getCurrentUser())) {
			String userType = getCurrentUser().getUserType();
			if (userType.equals(USERTYPE_C)) {
				String address = getCurrentUser().getAddress();
				cityName = address.substring(address.indexOf("省") + 1, address.length());
			}
		}
		weatherList = parseWeatherInfo(cityName);
		mav.addObject("datalist", weatherList);
		mav.setViewName("/index");
		return mav;
	}
	
	/**
	 * 根据城市名搜索
	 * 
	 * @param cityName 搜索关键字
	 * @return
	 */
	@RequestMapping(value = "/search")
	public ModelAndView search(String cityName) {
		ModelAndView mav = new ModelAndView();
		if (!BlankUtil.isBlank(cityName)) {
			List<Weather> weatherList = parseWeatherInfo(cityName);
			mav.addObject("datalist", weatherList);
		}
		mav.setViewName("/index");
		return mav;
	}
	
	/**
	 * 天气预报详情
	 * 
	 * @param id 天气预报Id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable(value = "id") Long id) {
		ModelAndView mav = new ModelAndView();
		Weather weather = iWeatherService.queryById(id);
		if (Objects.nonNull(weather)) {
			mav.addObject("weather", weather);
		}
		mav.setViewName("/view");
		return mav;
	}
	
	/**
	 * 删除天气信息
	 * 
	 * @param id 天气预报Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonViewData delete(String id) {
		if (Objects.nonNull(id)) {
			boolean deleted = iWeatherService.delete(Long.valueOf(id));
			return deleted ? setJsonViewData(ResultCode.SUCCESS) : setJsonViewData(ResultCode.FAIL, "删除失败！");
		}
		return setJsonViewData(ResultCode.FAIL, "用户Id有误！");
	}

}
