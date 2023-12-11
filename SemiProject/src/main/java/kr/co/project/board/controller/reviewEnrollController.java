package kr.co.project.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.service.BoardServiceImpl;


@WebServlet("/reviewEnroll.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 3, // 5MB
		maxRequestSize = 1024 * 1024 * 3 * 3 // 25MB
		)
public class reviewEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public reviewEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int no = (Integer) session.getAttribute("no");
		
		// 1. 입력내용 받기
		String reviewTitle = request.getParameter("title");
		String reviewContent = request.getParameter("content");
		String room = request.getParameter("room");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String type = request.getParameter("withWho");
		String star = request.getParameter("rating");
		String reviewPhoto1 = request.getParameter("reviewPhoto1");
		
		// 2. 파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "C:\\Users\\kaw19\\git\\SemiProject\\SemiProject\\src\\main\\webapp\\resources\\uploads\\review";

		// 파일 업로드하려는 디렉토리 없으면 생성
		File reviewRoute = new File(uploadDirectory);
		if(!reviewRoute.exists()) {
		    reviewRoute.mkdirs();
		}

		List<String> reviewPhotos = new ArrayList<String>();
		
		if(!reviewPhotos.isEmpty()) {
		    reviewPhoto1 = reviewPhotos.get(0);
		}
		for(Part part : parts) {
		    List<String> fileName = getReviewPhotos(part);

		    if(fileName != null && !fileName.isEmpty()) {
		        part.write(reviewRoute + File.separator + fileName);
		        reviewPhotos.addAll(fileName);
		    }
		}

		if(!reviewPhotos.isEmpty()) {
		    reviewPhoto1 = reviewPhotos.get(0);
		}
		BoardServiceImpl boardService = new BoardServiceImpl();
		BoardDTO board = new BoardDTO();
		board.setReviewTitle(reviewTitle);
		board.setReviewContent(reviewContent);
		board.setRoom(room);
		board.setYear(year);
		board.setMonth(month);
		board.setType(type);
		board.setStar(star);
		board.setReviewRoute1(uploadDirectory);
		board.setReviewPhotos(reviewPhotos);

		
		int result = 0;
		// 데이터 길이 검증
		if(reviewTitle.length() == 0 || reviewContent.length() == 0 ) {
			result = 0;
		} else {
		
			result = boardService.reviewEnroll(board, no);
		}
		
		// 4. 성공 유무에 따라 처리
		if(result > 0) {
			response.sendRedirect("/views/board/reviewEnroll.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/test");
			view.forward(request, response);
		}
	}
	
	
	
	

	// 파일 이름 가지고 오는 메소드
	private List<String> getReviewPhotos(Part part) {
	    List<String> reviewPhotos = new ArrayList<String>();
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            String fileName = s.substring(s.indexOf("=") + 2, s.length()-1);
	            reviewPhotos.add(fileName);
	        }
	    }
	    return reviewPhotos;
	}

}
