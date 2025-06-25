package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bordWrite",
			urlPatterns = "/board/write")
public class ReceiveTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveTitleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		String title = request.getParameter("title");
		RequestDispatcher view = request.getRequestDispatcher("/views/titleShow.jsp");
		request.setAttribute("title", title);
		view.forward(request, response);
	}

}
