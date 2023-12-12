package kr.co.project.notice.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.notice.dto.NoticeDTO;
import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/NoticeDetail.do")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		NoticeServiceImpl noticeService = new NoticeServiceImpl();
		int result = noticeService.noticeView(boardNo);

		// 조회수 증가가 성공하면 아래 내용 진행
		if (result > 0) {
			NoticeDTO notice = new NoticeDTO();
			notice.setBoardNo(boardNo);
			
			// 댓글 관련도 같이 가져옴
			noticeService.noticeSelect(notice);
			if(!Objects.isNull(notice.getBoardNo())) {
				request.setAttribute("board", notice);
				RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeDetail.jsp");
				view.forward(request, response);
			}
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
