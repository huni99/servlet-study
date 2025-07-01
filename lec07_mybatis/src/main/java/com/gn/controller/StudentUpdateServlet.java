package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService service = new StudentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo =Integer.parseInt(request.getParameter("no"));
		Student student = service.getStudentDetail(studentNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/views/studentUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 처리(utf-8)
		request.setCharacterEncoding("utf-8");
		// 2. 정보 가져오기(번호,이름,나이)
		String name = request.getParameter("studentName");
		int age =Integer.parseInt(request.getParameter("studentAge"));
		int no =Integer.parseInt(request.getParameter("studentNo"));
		// 3. service한테 부탁해서 updateStudent
		int result = service.updateStudent(no, name , age);
		
		// 부탁할때는 번호 이름 나이 주면서 
		// 결과는 int 형태롤 반환
		
		// 4. 만약에 결과가 0보다 크면 : 목록 화면 전환 다시 요청
		if(result>0) {
			response.sendRedirect("/student/list");
		}else {
			response.sendRedirect("/student/detail?no="+no);
		}
		// 	  0보다 크지 않다면 : 수정 화면으로 다시 요청 - > 반드시 쿼리 스트링!!
		
	}

}
