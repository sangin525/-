package kr.co.project.room.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/gradeInfo.do")
public class GradeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GradeInfoController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomServiceImpl roomService = new RoomServiceImpl();
		ArrayList<RoomDTO> room = roomService.gradeInfo();
		ArrayList<RoomDTO> roomDetail = roomService.roomDetail();
		
		
		request.setAttribute("room", room);
		request.setAttribute("roomDetail", roomDetail);
		RequestDispatcher view = request.getRequestDispatcher("/views/room/roomInfo.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
