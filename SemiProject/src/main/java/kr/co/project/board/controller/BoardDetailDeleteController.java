package kr.co.project.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/boardDelete.do")
public class BoardDetailDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		int result = boardService.boardDelete(boardNo);
		
		if(result > 0) {
			response.sendRedirect("BoardList.do");
		}else {
			response.sendRedirect("/views/common/error.jsp");
		}
	}

}
