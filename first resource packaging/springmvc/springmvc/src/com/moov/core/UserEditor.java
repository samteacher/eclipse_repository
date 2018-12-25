package com.moov.core;

import java.beans.PropertyEditorSupport;

import com.moov.web.TmStringUtils;

/**
 * User
 * @author Administrator
 *
 */
public class UserEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(TmStringUtils.isNotEmpty(text)){
			System.out.println(text);
		}else {
			setValue(null);
		}
	}
	
}
