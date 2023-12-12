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

@WebServlet("/basketEnroll.do")
public class BasketListEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BasketListEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodName = request.getParameter("foodName");
		int foodPrice = Integer.parseInt(request.getParameter("foodPrice"));
		String foodTime = request.getParameter("foodTime");
		int foodCount = Integer.parseInt(request.getParameter("foodCount"));
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		int result = roomService.basketEnroll(memberNo, foodName, foodPrice, foodTime, foodCount);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
