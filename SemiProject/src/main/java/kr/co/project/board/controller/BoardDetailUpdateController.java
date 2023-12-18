package kr.co.project.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/boardUpdate.do")
public class BoardDetailUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo);
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		
		System.out.println(boardNo);
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		BoardDTO board = new BoardDTO(title, content, boardNo);
		
		int result = boardService.boardUpdate(board);
		if(result > 0) {
			response.sendRedirect("BoardList.do?cpage=1");
		}else {
			response.sendRedirect("views/common.error.jsp");
		}
		
	}

}
