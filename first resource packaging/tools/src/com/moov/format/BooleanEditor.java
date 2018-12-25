package com.moov.format;

import java.beans.PropertyEditorSupport;

import com.moov.web.TmStringUtils;

/**
 * boolean
 * springmvc类型转换
 * @author Administrator
 *
 */
public class BooleanEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(TmStringUtils.isNotEmpty(text)){
			if(text.equalsIgnoreCase("3"))setValue(true);
			if(text.equalsIgnoreCase("4"))setValue(false);
		}else {
			setValue(false);
		}
	}
}
