package kr.co.project.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 5 * 5 // 25MB
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

		// 2. 파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "C:\\Users\\kaw19\\eclipse-workspace\\ServletProject\\src\\main\\webapp\\resources\\uploads";

		// 파일 업로드하려는 디렉토리 없으면 생성
		File filePath = new File(uploadDirectory);
		if(!filePath.exists()) {
		    filePath.mkdirs();
		}

		List<String> reviewPhotos = new ArrayList<String>();

		for(Part part : parts) {
		    if (part.getName().startsWith("reviewPhoto")) {
		        String fileName = getFileName(part);

		        if(fileName != null) {
		            part.write(filePath + File.separator + fileName);
		            reviewPhotos.add(fileName);
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

		if(!reviewPhotos.isEmpty()) {
		    board.setPhoto1Route(uploadDirectory);
		    board.setPhoto1Name(reviewPhotos.get(0));

		    if(reviewPhotos.size() > 1) {
		        board.setPhoto2Route(uploadDirectory);
		        board.setPhoto2Name(reviewPhotos.get(1));
		    }
		    if(reviewPhotos.size() > 2) {
		        board.setPhoto3Route(uploadDirectory);
		        board.setPhoto3Name(reviewPhotos.get(2));
		    }
		    if(reviewPhotos.size() > 3) {
		        board.setPhoto4Route(uploadDirectory);
		        board.setPhoto4Name(reviewPhotos.get(3));
		    }
		    if(reviewPhotos.size() > 4) {
		        board.setPhoto5Route(uploadDirectory);
		        board.setPhoto5Name(reviewPhotos.get(4));
		    }
		}

		
		int result = 0;
		// 데이터 길이 검증
		if(reviewTitle.length() == 0 || reviewContent.length() == 0 ) {
			result = 0;
		} else {
		
			result = boardService.reviewEnroll(board, no);
		}
		
		// 4. 성공 유무에 따라 처리
		if(result > 0) {
			response.sendRedirect("/reviewList.do?cpage=1");
		} else {
			ReviewAlert(response, "필수항목을 모두 입력해 주세요.");
		}
	}
	
	
	
	

	// 파일 이름 가지고 오는 메소드
		private String getFileName(Part part) {
			String contentDisposition = part.getHeader("content-disposition");
			
			// 세미콜론을 기준으로 토큰을 나눠 배열로 저장
			String[] tokens = contentDisposition.split(";");
			
			// 토큰을 하나씩 꺼내면서 토큰의 이름이 filename으로
			// 시작하는걸 찾을 때 까지 반복
			for(String token : tokens) {
				// 토큰의 이름이 filename으로 시작하는지 확인
				if(token.trim().startsWith("filename")) {
					// 파일의 이름이 "filename=" 다음에 나오기 때문에
					// "filename=" 의 다음 문자부터 끝까지 추출
					return token.substring(token.indexOf('=')+2, token.length()-1);
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
