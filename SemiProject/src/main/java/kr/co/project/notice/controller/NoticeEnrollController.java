package kr.co.project.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.project.notice.dto.NoticeDTO;
import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/noticeEnroll.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5
)
public class NoticeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		
		NoticeDTO notice = new NoticeDTO();
		
		HttpSession session = request.getSession();
		int memberNo = (Integer) session.getAttribute("no");

//		파일 업로드 처리 추가
		Collection<Part> parts = request.getParts();

		String uploadDirectory = "C:\\Users\\kaw198\\git\\SemiProject\\SemiProject\\src\\main\\webapp\\resources\\boardUpload";	

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

		NoticeServiceImpl noticeService = new NoticeServiceImpl();

		// 실행
		
		int result = noticeService.noticeEnroll(title, content, memberNo, fileName, uploadDirectory);
		if (result > 0) {
			response.sendRedirect("/NoticeList.do?cpage=1");
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