package kr.co.project.room.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/itemPayComplite.do")
public class ItemPayCompliteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemPayCompliteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		
		ArrayList<RoomDTO> itemPayList = roomService.itemPayList(memberNo);
		request.setAttribute("itemPayList", itemPayList);
		RequestDispatcher view = request.getRequestDispatcher("/views/room/PayBasketList.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}





























