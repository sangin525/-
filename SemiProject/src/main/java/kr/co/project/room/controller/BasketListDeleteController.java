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

@WebServlet("/basketDelete.do")
public class BasketListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BasketListDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int foodBasketNo = Integer.parseInt(request.getParameter("foodBasketNo"));
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		int result = roomService.basketDelete(foodBasketNo, memberNo);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
