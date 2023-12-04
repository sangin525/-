package kr.co.project.board.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/answerDelete.do")
public class AnswerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnswerDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int answerNo = Integer.parseInt(request.getParameter("answerNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		int result = boardService.answerDelete(answerNo);
		
		if(result > 0) {
			int answerDelete = boardService.answerDeleteUpdate(boardNo);
				// 답변 삭제 완료 시 답변 여부 N으로 변경
				if(answerDelete > 0) {
					response.sendRedirect("BoardDetail.do?boardNo=" + boardNo);
				}else{
					System.out.println("answerDelete의 값이 0");
				}
		}
		
		
	}

}
