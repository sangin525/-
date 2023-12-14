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

@WebServlet("/itemReserveEnroll.do")
public class ItemReserveEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemReserveEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String payItemNo = request.getParameter("payItemNo");
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		int basketMLG = Integer.parseInt(request.getParameter("basketMLG"));
	
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		RoomServiceImpl roomService = new RoomServiceImpl();
		
		
		roomService.basketPayEnrollMLG(memberNo, totalPrice, basketMLG);
		
		int result = roomService.changeReservePay(payItemNo,memberNo);
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

}


















