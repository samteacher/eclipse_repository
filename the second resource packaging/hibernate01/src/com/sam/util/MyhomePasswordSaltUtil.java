package com.sam.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyhomePasswordSaltUtil {

	public static String getSaltPassword(String password){
		try {
			return getSaltPassword(password, "lexiaoer");
		} catch (Exception e) {
			return "lexiaoer";
		}
	}
	
	public static String getSaltPassword(String password,String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update((password+salt).getBytes("UTF8"));
		byte[] by = md.digest();
		String result = "";
		for(int i=0;i<by.length;i++){
			result+=Integer.toHexString((0x000000ff & by[i]) | 0xffffff00).substring(6);
		}
		return result;
	}
}
