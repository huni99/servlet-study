package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		
		if(userName.equals(correctId)&&userPw.equals(correctPw)) {
			HttpSession session = request.getSession();
			Account ac = new Account();
			
			session.setAttribute("account",ac.getName());
			String n = (String)session.getAttribute("account");
			session.setMaxInactiveInterval(60 * 30);
			response.sendRedirect("/");
		}
		else {
			response.sendRedirect("/");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
