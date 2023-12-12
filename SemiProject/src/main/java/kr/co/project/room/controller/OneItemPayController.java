package kr.co.project.room.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/OneItemPay.do")
public class OneItemPayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OneItemPayController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int memberNo = (int) session.getAttribute("no");
		String foodName = request.getParameter("foodName");
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		String foodTime = request.getParameter("foodTime");
		int foodDetailCount = Integer.parseInt(request.getParameter("foodDetailCount"));
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		int result = roomService.oneItemPay(memberNo, foodName, totalPrice, foodTime, foodDetailCount);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

}
































