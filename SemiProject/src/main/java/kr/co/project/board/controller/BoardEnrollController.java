package kr.co.project.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/boardEnroll.do")
public class BoardEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		int memberNo = (Integer)session.getAttribute("M_NO");
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		int result = boardService.boardEnroll(title, content, memberNo);
		System.out.println(result);
		if(result > 0) {
			response.sendRedirect("/BoardList.do");
		}else {
			response.sendRedirect("/views/common/error.jsp");
		}
		
	}

}
