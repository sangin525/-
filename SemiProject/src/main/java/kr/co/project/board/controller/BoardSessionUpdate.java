package kr.co.project.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardSessionUpdate.do")
public class BoardSessionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSessionUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 스마트 에디터 삽입 후 수정에 오류가 발생하여 세션 값을 넣을 Controller가 필요하여 작성된 서블릿
		String boardNo = request.getParameter("boardNo");
		
		HttpSession session = request.getSession(true);
        session.setAttribute("boardNo", boardNo);
        System.out.println(boardNo);
        response.sendRedirect("views/board/boardUpdate.jsp");
        
	}

}
