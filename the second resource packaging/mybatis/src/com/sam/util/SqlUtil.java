package com.sam.util;

public class SqlUtil {

	/**
	 * 判断一个元素是否为空，如果为空true 否则false
	 * 方法名：isEmpty
	 * 创建人：xuchengfei 
	 * 时间：2016年3月24日-下午11:49:00 
	 * 手机:1564545646464
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isEmpty(String content){
		return null!=content && "".equals(content);
	}
	
	/**
	 * 字符串非空判断
	 * 方法名：isNotEmpty
	 * 创建人：xuchengfei 
	 * 时间：2016年3月25日-上午12:00:00 
	 * 手机:1564545646464
	 * @param content
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isNotEmpty(String content){
		return !isEmpty(content);
	}
}
