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
//@WebFilter(urlPatterns = "/receive/data")
@WebFilter(urlPatterns = "/receive/*")
//url이 /receive/ 로 시작하는 모든것들이 이 filter를 지나감
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
		
		
		//chain.doFilter는 요청과 응답을 가로막는 메소드
		//1. 요청이 필터를 지나가기 전에 할 작업
		System.out.println("[DataFilter] 요청 가로챔");
		//2. 다음 필터나 서블릿으로 요청을 넘김
		chain.doFilter(request, response);
		//3. 서블릿의 작업이 끝나고 클라이언트로 가기전 작업
		System.out.println("[DataFilter] 응답 가로챔");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//필터가 초기화 될 때 실행
	}

}
