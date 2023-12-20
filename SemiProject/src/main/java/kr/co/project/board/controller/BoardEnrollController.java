package kr.co.project.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;

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

@WebServlet("/boardEnroll.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5

)
public class BoardEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardEnrollController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		String secretBox = request.getParameter("secretBox");
		
		BoardDTO board = new BoardDTO();
		String categoryHidden = request.getParameter("checkHidden");
		
		
		
		HttpSession session = request.getSession();
		int memberNo = (Integer) session.getAttribute("no");

//		파일 업로드 처리 추가
		Collection<Part> parts = request.getParts();

		String uploadDirectory = "C:\\Users\\USER\\git\\SemiProject\\SemiProject\\src\\main\\webapp\\resources\\boardUpload";	

		File filePath = new File(uploadDirectory);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		String fileName = null;

		for (Part part : parts) {
			fileName = getFileName(part);
			if (fileName != null) {
				if (!fileName.equals("")) {
					part.write(filePath + File.separator + fileName);
				}
			}
		}

		BoardServiceImpl boardService = new BoardServiceImpl();

		// 실행
		
		int result = boardService.boardEnroll(title, content, memberNo, fileName, uploadDirectory, categoryHidden, secretBox);
		if (result > 0) {
			String category = URLEncoder.encode("전체","utf-8");
			response.sendRedirect("/BoardList.do?cpage=1&category="+category);
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}

	}

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

}
