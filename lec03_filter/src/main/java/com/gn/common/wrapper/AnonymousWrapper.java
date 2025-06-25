package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper {

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override 
	public String getParameter(String str) {
		String name = super.getParameter(str);
		if(str.equals("writer")) {
			if(name.equals(null)||name.equals("익명")){
				return name;
			}
			return "익명";
		}
		return name;
		
	
	}
}
