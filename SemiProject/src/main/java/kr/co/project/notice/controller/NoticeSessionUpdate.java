package kr.co.project.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/noticeSessionUpdate.do")
public class NoticeSessionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeSessionUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 스마트 에디터 삽입 후 수정에 오류가 발생하여 세션 값을 넣을 Controller가 필요하여 작성된 서블릿
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		HttpSession session = request.getSession(true);
        session.setAttribute("boardNo", boardNo);
        response.sendRedirect("views/notice/noticeUpdate.jsp");
        
	}

}
