package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/createSession")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션 객체 생성
		// -> 매개변수 default는 true 값이다 : 세션이 없을때 만드는거 동의한다
		// 	  매개변수가 false : 세션이 없을때 만드는거 비동의
		//session은 서버 여기서는 톰캣이 생성 개발자는 이걸 가져다가 사용
		HttpSession session = request.getSession();
		//2. 세션 속성값 지정 
		// (1) 새로운 세션인지 확인하고 싶을때
		if(session.isNew()) {
			
		}
		// (2)기존에 특정 key에 해당하는 값이 있는가
		if(session.getAttribute("member_id")==null) {
			
		}
		
		session.setAttribute("member_id", "user01");
		session.setMaxInactiveInterval(60 * 30);
		// 홈 화면 이동
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
