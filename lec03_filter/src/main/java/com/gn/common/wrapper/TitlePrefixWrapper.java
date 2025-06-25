package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class TitlePrefixWrapper extends HttpServletRequestWrapper{

	public TitlePrefixWrapper(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String title) {
		
		String value = super.getParameter(title);
		if(title.equals("title")&&value!=null) {
			value="[공지]"+value;
		}
		return value;
	}

}
