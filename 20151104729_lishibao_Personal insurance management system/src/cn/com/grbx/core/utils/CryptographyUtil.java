package cn.com.lhd.core.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 
 * @desc 加密工具
 */
public class CryptographyUtil {

public static final String SALT = "luohaidian"; // 加密
	
	/**
	 * Md5加密
	 * @param str 密码
	 * @param salt 加盐
	 * @return
	 */
	public static String md5(String str, String salt){
		return new Md5Hash(str, salt).toString();
	}
	
	public static void main(String[] args) {
		String password="123456";
		
		System.out.println("Md5加密："+CryptographyUtil.md5(password, SALT));
	}
	
}
