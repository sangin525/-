package kr.co.project.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

@WebServlet("/reviewUpdate.do")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class reviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public reviewUpdateController() {
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
		
		// 1. 입력내용 받기
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String reviewTitle = request.getParameter("title");
		String reviewContent = request.getParameter("content");
		String room = request.getParameter("room");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String type = request.getParameter("withWho");
		String star = request.getParameter("rating");
		// 2. 파일 업로드
		Collection<Part> parts = request.getParts();

		String uploadDirectory = "C:\\Users\\kaw19\\git\\SemiProject\\SemiProject\\src\\main\\webapp\\resources\\uploads\\review";	

		File filePath = new File(uploadDirectory);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		String fileName = null;

		List<String> fileNames = new ArrayList<>();  // 파일명들을 저장할 리스트를 생성합니다.

		for (Part part : parts) {
			fileName = getFileName(part);
			if (fileName != null) {
				if (!fileName.equals("")) {
					part.write(filePath + File.separator + fileName);
					fileNames.add(fileName);  // 파일명을 리스트에 추가합니다.
				}
			}
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
		board.setFileNames(fileNames);  // BoardDTO 객체에 파일명 리스트를 저장합니다.

		
		
		int result = 0;
		// 데이터 길이 검증
		if(reviewTitle.length() == 0 || reviewContent.length() == 0 ) {
			result = 0;
		} else {
		
			result = boardService.reviewUpdate(board, reviewNo);
		}
		
		// 4. 성공 유무에 따라 처리
		    if(result > 0) {
		        response.sendRedirect("/reviewList.do?cpage=1");
		        return;
		    } else {
		        ReviewAlert(response, "필수항목을 모두 입력해 주세요.");
		    }
		}
		
	
	
	
	

	// 파일 이름 가지고 오는 메소드
	 private String getFileName(Part part) {
	        String contentDisposition = part.getHeader("content-disposition");
	        String[] tokens = contentDisposition.split(";");

	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	                return token.substring(token.indexOf('=') + 2, token.length() - 1);
	            }
	        }
	        return null;
	    }


private void ReviewAlert(HttpServletResponse response, String msg) throws IOException {
	PrintWriter out = response.getWriter();
	out.println("<script>" + "		location.href='/board/review.do';" + "		alert('" + msg + "');"
			+ "	</script>");
	out.flush();
	out.close();
}
	}


