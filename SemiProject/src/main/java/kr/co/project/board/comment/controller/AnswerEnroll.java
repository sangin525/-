package kr.co.project.board.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/answerEnroll.do")
public class AnswerEnroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnswerEnroll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String answer = request.getParameter("comment");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String name = (String)session.getAttribute("name");
		String admin = (String)session.getAttribute("admin");
		
		BoardServiceImpl boardService = new BoardServiceImpl();
				
		// 공지사항이기에 Admin만 작성이 가능하여 아래와 같은 비교문이 추가됨
		if("Y".equals(admin)){
			int result = boardService.answerEnroll(answer, name, boardNo);
			
			if(result > 0) {
				int answerUpdate = boardService.answerUpdate(boardNo);
					if(answerUpdate > 0) {
						response.sendRedirect("/BoardDetail.do?boardNo=" + boardNo);
					}else {
						System.out.println("answer Update 오류");
					}
			}else {
				response.sendRedirect("/views/common/error.jsp");
			}			
		}else {
			System.out.println("관리자 인증 실패 / CommentEnroll");
		}
	}

}
