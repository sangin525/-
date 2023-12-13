package kr.co.project.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/noticeDelete.do")
public class NoticeDetailDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDetailDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		NoticeServiceImpl noticeService = new NoticeServiceImpl();
		
		int result = noticeService.noticeDelete(boardNo);
		
		if(result > 0) {
			response.sendRedirect("NoticeList.do?cpage=1");
		}else {
			response.sendRedirect("/views/common/error.jsp");
		}
	}

}
