package kr.co.project.member.form.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberServiceImpl;


@WebServlet("/MyPageForm.do")
public class MyPageFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyPageFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int no = (int) session.getAttribute("no");
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		MemberDTO member = memberService.selectMlg(no);
		
		session.removeAttribute("mlg");
		session.removeAttribute("membership");
		session.removeAttribute("accamount");
		
		session.setAttribute("mlg", member.getMlg());
		session.setAttribute("membership", member.getMembership());
		session.setAttribute("accamount", member.getAccAmount());
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/mypage/MyPage.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
