package cn.com.lhd.core;

import java.io.Serializable;

/**
 * 枚举契约
 */
public interface EnumValue<T extends Serializable> {
	
	T getValue();

}
