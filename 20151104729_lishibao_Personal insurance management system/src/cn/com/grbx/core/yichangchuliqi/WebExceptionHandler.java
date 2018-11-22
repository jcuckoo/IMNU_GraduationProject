package cn.com.lhd.core.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;

import cn.com.lhd.core.EnumValue;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.core.exception.HeaderException;
import cn.com.lhd.core.utils.BlankUtil;

/**
 * 异常处理器
 */
public class WebExceptionHandler extends AbstractHandlerExceptionResolver {

	private FastJsonConfig fastJsonConfig;

	private static Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

	private String errorViewName = "/";

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		boolean isRestful = false;
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			isRestful = !BlankUtil.isBlank(handlerMethod.getMethod().getAnnotation(ResponseBody.class))
					|| !BlankUtil.isBlank(handlerMethod.getBeanType().getAnnotation(RestController.class));
			if (ex instanceof HeaderException) {
				EnumValue<?> enumValue = ((HeaderException) ex).getEnumValue();
				String errorMessage = ex.getMessage();
				return resolveView(isRestful, enumValue, errorMessage);
			}
		}
		logger.error(ex.getMessage(), ex);
		return resolveView(isRestful, ResultCode.SYSTEM_ERROR, ResultCode.SYSTEM_ERROR.getDescription());
	}

	private ModelAndView resolveView(boolean isRestful, EnumValue<?> code, String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setStatus(HttpStatus.OK);
		modelAndView.addObject("resultCode", code.getValue());
		modelAndView.addObject("message", message);
		if (isRestful) {
			FastJsonJsonView fastJsonJsonView = new FastJsonJsonView();
			fastJsonJsonView.setFastJsonConfig(fastJsonConfig);
			modelAndView.setView(fastJsonJsonView);
		} else {
			modelAndView.setViewName(errorViewName);
		}
		return modelAndView;
	}

	@Override
	protected void logException(Exception ex, HttpServletRequest request) {

	}

	public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
		this.fastJsonConfig = fastJsonConfig;
	}

	public void setErrorViewName(String errorViewName) {
		this.errorViewName = errorViewName;
	}
	
}
