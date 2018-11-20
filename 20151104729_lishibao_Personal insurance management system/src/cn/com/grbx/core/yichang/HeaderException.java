package cn.com.lhd.core.exception;

import cn.com.lhd.core.EnumValue;

/**
 * 异常基类
 */
public abstract class HeaderException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public abstract EnumValue<?> getEnumValue();

    protected HeaderException(String message){
        super(message);
    }

    protected HeaderException(String message,Throwable cause){
        super(message,cause);
    }

}
