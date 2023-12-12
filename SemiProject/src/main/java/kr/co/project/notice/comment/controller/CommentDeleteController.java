package kr.co.project.notice.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/commentDelete.do")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		NoticeServiceImpl noticeService = new NoticeServiceImpl();
		
		int result = noticeService.commentDelete(commentNo);
		
		if(result > 0) {
			response.sendRedirect("NoticeDetail.do?boardNo=" + boardNo);
		}
	}
}
