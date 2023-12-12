package kr.co.project.notice.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/commentDetailUpdate.do")
public class CommentDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("comment");
		String boardNo = request.getParameter("boardNo");
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		NoticeServiceImpl noticeService = new NoticeServiceImpl();
		
		int result = noticeService.commentDetailUpdate(content, commentNo);
		
		if(result > 0) {
			response.sendRedirect("NoticeDetail.do?boardNo=" + boardNo);
		}else{
			response.sendRedirect("views/common/error.jsp");
			
		}
		
	}

}
