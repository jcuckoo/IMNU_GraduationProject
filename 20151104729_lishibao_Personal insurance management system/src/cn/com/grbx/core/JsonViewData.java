package cn.com.lhd.core;

import com.alibaba.fastjson.JSON;
import com.google.common.net.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Json 封装类 用于返回前端JSON格式串
 */
public class JsonViewData {

	/**
	 * 未登陆或超时视图
	 */
	public static final JsonViewData NO_LOGIN_VIEW = new JsonViewData(ResultCode.NO_LOGIN);

	private ResultCode resultCode;// 操作结果码

	private String message;// 消息提示

	private Object data;// 有效数据包

	public JsonViewData(ResultCode resultCode) {
		this(resultCode, resultCode.getDescription());
	}

	public JsonViewData(ResultCode resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}

	public JsonViewData(Object data) {
		this(ResultCode.SUCCESS);
		this.data = data;
	}

	public void write(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.JSON_UTF_8.withoutParameters().toString());
		JSON.writeJSONString(response.getWriter(), this);
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}
