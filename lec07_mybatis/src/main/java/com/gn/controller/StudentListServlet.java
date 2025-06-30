package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.gn.dto.Student;
import com.gn.service.StudentService;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 3. Service에 정보 전달
		List<Student> list =service.getStudentList();
//		 4. DAO에 데이터 베이스 연결 요청
//		 5. Mapper에 있는 쿼리 실행
//			-> 학생 정보 목록 조회
//		 6./views/studentList.jsp로 보내기
		System.out.println(list.get(0).getStudentName());
		request.setAttribute("mybatis", list);
		RequestDispatcher view =request.getRequestDispatcher("/views/studentList.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
