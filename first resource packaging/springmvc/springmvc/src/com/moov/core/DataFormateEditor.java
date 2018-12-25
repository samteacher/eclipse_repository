package com.moov.core;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.moov.web.TmStringUtils;

/**
 * 日期转换
 * @author Administrator
 */
public class DataFormateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(TmStringUtils.isNotEmpty(text)){
			String pattern = "yyyy-MM-dd";
			if(text.indexOf(":")!=-1)pattern = "yyyy-MM-dd HH:mm:ss";
			try {
				setValue(new SimpleDateFormat(pattern).parse(text));
			} catch (ParseException e) {
				setValue(null);
			}
		}else {
			setValue(null);
		}
	}

}
