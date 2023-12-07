package kr.co.project.hotel.form.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hotel/*")
public class HotelFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HotelFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/HotelInfo.do")) {
			nextPage="/views/HotelInfo/hotelInfo.jsp";
		} else if(action.equals("/HotelPath.do")) {
			nextPage = "/views/HotelInfo/hotelPath.jsp";
		} else if(action.equals("/HotelRestaurant.do")) {
			nextPage = "/views/HotelInfo/hotelRestaurant.jsp";
		} else if(action.equals("/HotelPool.do")) {
			nextPage = "/views/HotelInfo/hotelPool.jsp";
		} else if(action.equals("/HotelSpa.do")) {
			nextPage = "/views/HotelInfo/hotelSpa.jsp";
		} else if(action.equals("/HotelGame.do")) {
			nextPage = "/views/HotelInfo/hotelGame.jsp";
		} else if(action.equals("/HotelMemberShip.do")) {
			nextPage = "/views/HotelInfo/hotelMemberShip.jsp";
		} else if(action.equals("/HotelHealth.do")) {
			nextPage = "/views/HotelInfo/hotelHealth.jsp";
		}
		
		
		if(nextPage !=null && !nextPage.isEmpty()) {
			
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
