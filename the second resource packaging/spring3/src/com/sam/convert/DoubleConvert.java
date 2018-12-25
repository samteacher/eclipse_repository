package com.sam.convert;

import java.beans.PropertyEditorSupport;
import java.text.DecimalFormat;

/**
 * 日期轉換
 * @author Administrator
 *
 */
public class DoubleConvert  extends PropertyEditorSupport{
	
	private String format;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		java.text.DecimalFormat sdf = new DecimalFormat(format);
		this.setValue(sdf.format(Double.parseDouble(text)));
		
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
