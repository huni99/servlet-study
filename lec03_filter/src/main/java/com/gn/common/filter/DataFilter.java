package com.gn.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

//@WebFilter(servletNames = "receiveDataServele")
@WebFilter(urlPatterns = "/receive/data")
public class DataFilter extends HttpFilter implements Filter {
    public DataFilter() {
        super();
    }
	public void destroy() {
	// 필터가 소멸될 때 실행
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청과 응답을 처리 
		// 요청이 servlet으로 들어 가기전에 필터가 실행되고 응답이 사용자에게 가기전에 실행된다
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//필터가 초기호 될 때 실행
	}

}
