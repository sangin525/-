package kr.co.project.room.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.room.model.dto.RoomDTO;

@WebServlet("/ReserveRoom.do")
public class ReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReserveController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션받아서 SELECT 로 예약자 이름 가져오는 코드작성 
		// 결제금액 날짜기준으로 가져와서 * 하기
		// 마일리리지 가져오기 후 적립하기
		String RName = request.getParameter("RName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int dateSum = Integer.parseInt(request.getParameter("dateSum"));
		int RPersonCount = Integer.parseInt(request.getParameter("RPersonCount"));
		
		
		
		RoomDTO room = new RoomDTO();
		room.setRoomName(RName);
		room.setRChkIn(startDate);
		room.setRChkOut(endDate);
		room.setRCount(dateSum);
		room.setRPersonCount(RPersonCount);
		
		request.setAttribute("room", room);
		RequestDispatcher view = request.getRequestDispatcher("/views/room/roomReserve.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
