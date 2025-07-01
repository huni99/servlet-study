package com.gn.controller;

import java.io.IOException;
import java.util.List;

import com.gn.dto.Student;
import com.gn.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/student/search")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService service = new StudentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("student_name");
		//name = "%"+name+"%";
		List<Student> list = service.getSearchList(name);
		request.setAttribute("name", list);
		request.getRequestDispatcher("/views/studentSearch.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
