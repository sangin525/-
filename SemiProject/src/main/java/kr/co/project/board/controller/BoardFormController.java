package kr.co.project.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/*")
public class BoardFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardFormController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/review.do")) {
			nextPage="/views/board/reviewEnroll.jsp";
		} else if(action.equals("/reviewUpdateForm.do")) {
			int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
			request.setAttribute("reviewNo", reviewNo);
			nextPage = "/views/board/reviewUpdate.jsp";
		}
		
		
		if(nextPage !=null && !nextPage.isEmpty()) {
			
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
