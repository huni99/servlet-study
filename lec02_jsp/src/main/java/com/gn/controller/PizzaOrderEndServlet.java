package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PizzaOrderEndServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		
		String time = request.getParameter("time");
		int size = Integer.parseInt(request.getParameter("size"));
		String s=null;
		int[] topping =Arrays.stream(request.getParameterValues("topping")).mapToInt(Integer::parseInt).toArray() ;
		String[] topName = new String[topping.length];
		int price=0;
		switch(size) {
		case 1:
			price=15900;
			s="small";
			break;
		case 2:
			price=21000;
			s="medium";
			break;
		case 3:
			price=27900;
			s="large";
			break;	
		}
		
		for(int i=0 ; i < topping.length; i++) {
			if(topping[i]==1) {
				price+=1000;
				topName[i]="새우";
			}
			else if( topping[i]==2)
			{
				topName[i]="고구마";
			}
			else if( topping[i]==3)
			{
				topName[i]="감자";
			}
			else if( topping[i]==4)
			{
				topName[i]="파인애플";
			}
			price+=1000;
		}
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("size", s);
		request.setAttribute("userName", userName);
		request.setAttribute("topName", topName);
		request.setAttribute("price", price);
		request.setAttribute("time", time);
		RequestDispatcher dis = request.getRequestDispatcher("/views/pizza/result.jsp");
		dis.forward(request, response);
	}

}
