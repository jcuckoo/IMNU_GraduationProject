package cn.com.lhd.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;

/**
 * 
 * @desc 基础数据控制器
 *
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest httpRequest;

    protected HttpServletResponse httpResponse;

    protected HttpSession httpSession;

    protected ModelMap modelMap;

    @ModelAttribute
    protected void initSpringMvcApiModel(
            HttpServletResponse httpResponse,
            HttpSession httpSession,
            ModelMap modelMap
    ) {
        this.httpResponse = httpResponse;
        this.httpSession = httpSession;
        this.modelMap = modelMap;
    }

    protected JsonViewData setJsonViewData(ResultCode resultCode) {
        return new JsonViewData(resultCode);
    }

    protected JsonViewData setJsonViewData(ResultCode resultCode, String message) {
        return new JsonViewData(resultCode,message);
    }

    protected JsonViewData setJsonViewData(Object data) {
        return new JsonViewData(data);
    }

}
