package kr.co.project.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.notice.dto.NoticeDTO;
import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/noticeUpdate.do")
public class NoticeDetailUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDetailUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			
		
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		
		NoticeServiceImpl noticeService = new NoticeServiceImpl();
		NoticeDTO notice = new NoticeDTO(title, content, boardNo);
		
		int result = noticeService.noticeUpdate(notice);
		if(result > 0) {
			response.sendRedirect("NoticeList.do?cpage=1");
		}else {
			response.sendRedirect("views/common.error.jsp");
		}
		
		}

}
