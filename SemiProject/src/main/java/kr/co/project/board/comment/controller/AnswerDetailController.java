package kr.co.project.board.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/answerDetailUpdate.do")
public class AnswerDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnswerDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("comment");
		String boardNo = request.getParameter("boardNo");
		int answerNo = Integer.parseInt(request.getParameter("answerNo"));
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		int result = boardService.answerDetailUpdate(content, answerNo);
		
		if(result > 0) {
			response.sendRedirect("BoardDetail.do?boardNo=" + boardNo);
		}else{
			response.sendRedirect("views/common/error.jsp");
			
		}
		
	}

}
