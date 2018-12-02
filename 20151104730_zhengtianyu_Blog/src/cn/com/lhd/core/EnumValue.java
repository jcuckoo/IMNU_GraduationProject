package cn.com.lhd.core;

import java.io.Serializable;

/**
 * 枚举契约
 *
 * @author luohaidian
 * @date 2018年7月13日
 * @time 上午11:49:29
 */
public interface EnumValue<T extends Serializable> {
	
	T getValue();

}
