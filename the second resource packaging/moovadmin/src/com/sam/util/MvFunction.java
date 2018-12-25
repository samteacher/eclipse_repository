package com.sam.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JSP自定义标签
 * MvFunction
 * 创建人:Sam
 * 时间：2017年2月26日-上午9:42:44 
 * @version 1.0.0
 *
 */
public class MvFunction {
	
	/**
	 * 将字符串转换成大写
	 * com.moov.util 
	 * 方法名：toUpper
	 * 创建人：Sam
	 * 时间：2017年2月26日-上午9:43:36 
	 * @param content
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String toUpper(String content){
		if(StringUtil.isEmail(content))return null;
		return content.toUpperCase();
	}
	
	/**
	 * 空判断
	 * com.moov.util 
	 * 方法名：isEmpty
	 * 创建人：Sam
	 * 时间：2017年2月26日-上午10:14:18 
	 * @param content
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isEmpty(String content){
		return null!=content && "".equals(content);
	}
	
	/**
	 * 
	 * com.moov.util 
	 * 方法名：stringToDate
	 * 创建人：Sam
	 * 时间：2017年2月26日-上午10:41:43 
	 * @param dateString
	 * @param pattern
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String dateFormat(String dateString,String format){
		if(StringUtil.isEmail(dateString))return "";
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
			String ds = new SimpleDateFormat(format).format(date);
			return ds;
		} catch (ParseException e) {
			return "";
		}
	}
	
	/**
	 * 把传入的数转换为中文金额大写形式
	 * @param flag int 标志位，1 表示转换整数部分，0 表示转换小数部分
	 * @param s String 要转换的字符串
	 * @return 转换好的带单位的中文金额大写形式
	 */
	public static String numFormat(String s,int flag) {
		int sLength = s.length();
		// 货币大写形式
		String bigLetter[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
		// 货币单位
		String unit[] = {"元", "拾", "佰", "仟", "万", 
				// 拾万位到仟万位
				"拾", "佰", "仟",
				// 亿位到万亿位
				"亿", "拾", "佰", "仟", "万"};
		String small[] = {"分", "角"};
		// 用来存放转换后的新字符串
		String newS = "";
		// 逐位替换为中文大写形式
		for(int i = 0; i < sLength; i ++) {
			if(flag == 1) {
				// 转换整数部分为中文大写形式（带单位）
				newS = newS + bigLetter[s.charAt(i) - 48] + unit[sLength - i - 1];
			} else if(flag == 2) {
				// 转换小数部分（带单位）
				newS = newS + bigLetter[s.charAt(i) - 48] + small[sLength - i - 1];
			}
		}
		return newS;
	}
	
	public static void main(String[] args) {
		System.out.println(numFormat("0",1));
	}
	
}
