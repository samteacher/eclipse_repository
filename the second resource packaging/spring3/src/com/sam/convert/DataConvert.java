package com.sam.convert;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期轉換
 * @author Administrator
 *
 */
public class DataConvert extends PropertyEditorSupport{
	
	private String format;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			this.setValue(sdf.parseObject(text));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
