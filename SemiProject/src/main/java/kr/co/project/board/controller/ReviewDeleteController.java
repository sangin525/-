package kr.co.project.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.service.BoardServiceImpl;


@WebServlet("/reviewDelete.do")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReviewDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		int result = boardService.reviewDelete(reviewNo);
		
		if(result > 0) {
			response.sendRedirect("reviewList.do?cpage=1");
		}else {
			response.sendRedirect("/views/common/error.jsp");
		}
		
	}

}
