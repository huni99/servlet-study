package com.gn.controller;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Attach;
import com.gn.dto.Board;
import com.gn.service.AttachService;
import com.gn.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWriteServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 20
)
@WebServlet("/boardWrite")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/board/write.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1. 게시글 정보 추출
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		int boardWriter =Integer.parseInt(request.getParameter("boardWriter"));
		Board board =new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardWriter(boardWriter);
		
		//2. 파일 정보 추출
		
		File uploadDir = AttachService.getUploadDirectory();
		Attach attach = AttachService.handleUploadFile(request, uploadDir);
		
		// 3. 게시글과 파일 정보 데이터베이스에 추가
		
		int result = boardService.createBoardWithAttach(board,attach);
		
		JSONObject obj = new JSONObject();
		
		if(result>0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "게시글 등록 성공");
		}else {
			obj.put("res_code", "500");
			obj.put("res_msg", "게시글 등록 중 오류발생 ");	
		}
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(obj);
		
		
		
		
		
		
		
		
		
		
	}

}
