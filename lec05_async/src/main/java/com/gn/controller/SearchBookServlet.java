package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("name");
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1, "자바의 정석", "김철수"));
		list.add(new Book(2, "스프링 입문", "이순신"));
		list.add(new Book(3, "MySQL 실습", "홍길동"));
		list.add(new Book(4, "웹 개발 가이드", "유관순"));
		list.add(new Book(5, "웹 가이드", "유관순"));

		JSONObject result = new JSONObject();
		JSONArray arr=  new JSONArray();
		if(!keyword.equals("")) {
			for(int i =0; i<list.size(); i++) {
				if(list.get(i).getBookName().contains(keyword)) {
					JSONObject obj = new JSONObject();
					obj.put("no",list.get(i).getNo());
					obj.put("name", list.get(i).getBookName());
					obj.put("writer", list.get(i).getWriter());
					arr.add(obj);
				}
			}
			if(arr.size()==0) return;
			
		}
		else {
			return;
		}
		result.put("arr", arr);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
