package kr.co.project.room.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/ReserveRoom.do")
public class ReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReserveController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomDTO room = new RoomDTO();
		String RName = request.getParameter("RName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int dateSum = Integer.parseInt(request.getParameter("dateSum"));
		int RPersonCount = Integer.parseInt(request.getParameter("RPersonCount"));
		String roomGrade = request.getParameter("roomDetailGrade");
		
		// 1. Date 생성 / 현재 날짜   주말 평일 구분하기
		SimpleDateFormat dateStart = new SimpleDateFormat("yyyy-MM-dd");
		Date startDay;
		Date endDay;
		try {
			startDay =  dateStart.parse(startDate);
			endDay =  dateStart.parse(endDate);
			
			Calendar calendar = Calendar.getInstance();    
			Calendar calendar1 = Calendar.getInstance();    
			calendar.setTime(startDay); 
			calendar1.setTime(endDay); 
			int startDayWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);         // 4. 요일 출력        System.out.println(dayOfWeekNumber);  // 7
			int endDayWeekNumber = calendar1.get(Calendar.DAY_OF_WEEK);         // 4. 요일 출력        System.out.println(dayOfWeekNumber);  // 7
			request.setAttribute("startDayWeekNumber", startDayWeekNumber);
			request.setAttribute("endDayWeekNumber", endDayWeekNumber);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 세션받아서 SELECT 로 예약자 이름 가져오는 코드작성     o
		// 결제금액 날짜기준으로 가져와서 * 하기       o
		// 마일리리지 가져오기 후 적립하기
		
		HttpSession session = request.getSession();
		String memberName = (String) session.getAttribute("name");
		
		RoomServiceImpl RoomService = new RoomServiceImpl();
		
		// 등급에따른 가격조회
		RoomDTO roomPrice = RoomService.getPrice(roomGrade);
		
		int memberNo = (int)session.getAttribute("no");
		
		// 마일리지 조회
		RoomDTO member = RoomService.searchMLG(memberNo);
		String membership = member.getMembership();
		double percentMLG;
		if(membership.equals("Silver")) {
			percentMLG = 0.03;
		}else if(membership.equals("Gold")) {
			percentMLG = 0.05;
		}else if(membership.equals("Platinum")) {
			percentMLG = 0.07;
		}else if(membership.equals("Black")) {
			percentMLG = 0.1;
		}else {
			percentMLG = 0;
		}
		int totalWeekday = Integer.parseInt(String.join("", roomPrice.getWeekdayPrice().split(",")));
		int totalWeekend = Integer.parseInt(String.join("", roomPrice.getWeekendPrice().split(",")));
    
		room.setRoomName(RName);
		room.setRChkIn(startDate);
		room.setRChkOut(endDate);
		room.setRCount(dateSum);
		room.setRPersonCount(RPersonCount);
		request.setAttribute("percentMLG", percentMLG);
		request.setAttribute("member", member);
		request.setAttribute("totalWeekday", totalWeekday);
		request.setAttribute("totalWeekend", totalWeekend);
		
		request.setAttribute("roomPrice", roomPrice);
		request.setAttribute("room", room);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/room/roomReserve.jsp");
		view.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
