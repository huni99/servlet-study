package com.gn.controller;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Member;
import com.gn.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/memberLogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 전달받은 정보가 일치하는 회원
		Member member = service.selectMember(memberId,memberPw);
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg","로그인 중 오류가 발생하였습니다.");
		if(member!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(60 * 30);
			obj.put("res_code", "200");
			obj.put("res_msg", "정상적으로 로그인되었습니다.");
		}
		
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(obj);
		//1. service : 바구니 옮겨담아서 dao 한테 전달하기
		//2. dao : 인터페이스한테 db 연결 요청하기
		//3. Mapper : mapper.xml한테 쿼리 호출하기
		//4. xml : select * 쿼리 구성 + resultMap (memberResultMap)
		
	}

}
