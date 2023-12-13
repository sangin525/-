package kr.co.project.notice.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/commentEnroll.do")
public class CommentEnroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentEnroll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String comment = request.getParameter("comment");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String name = (String)session.getAttribute("name");
		
		NoticeServiceImpl noticeService = new NoticeServiceImpl();
				
			int result = noticeService.commentEnroll(comment, name, boardNo);
			
			if(result > 0) {
				response.sendRedirect("/NoticeDetail.do?boardNo=" + boardNo);
			}else {
				response.sendRedirect("/views/common/error.jsp");
		}			
	}

}
