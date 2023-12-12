package kr.co.project.room.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/foodDetail.do")
public class FoodDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FoodDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodName = request.getParameter("foodName");
		
		RoomServiceImpl room = new RoomServiceImpl();
		RoomDTO food = room.foodDetail(foodName);
		
		request.setAttribute("food", food);
		RequestDispatcher view = request.getRequestDispatcher("/views/room/foodDetail.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
