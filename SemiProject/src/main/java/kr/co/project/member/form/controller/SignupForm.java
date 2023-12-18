package kr.co.project.member.form.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupForm.do")
public class SignupForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String termsCheckbox = request.getParameter("termsCheckbox");
		String privacyCheckbox = request.getParameter("privacyCheckbox");
		String confirmCheckbox = request.getParameter("confirmCheckbox");
		String snsCheckbox = request.getParameter("snsCheckbox");

		if (Objects.isNull(snsCheckbox)) {
			snsCheckbox = "n";
		}

		if (termsCheckbox == null || privacyCheckbox == null || confirmCheckbox == null) {
			response.sendRedirect("/");
		} else {
			request.setAttribute("snsCheckbox", snsCheckbox);
			RequestDispatcher view = request.getRequestDispatcher("/views/member/SignupForm.jsp");
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
