package kr.co.project.room.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;
/**
 * Servlet implementation class ReserveEnrollController
 */

@WebServlet("/ReserveEnroll.do")
public class ReserveEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReserveEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("memberName");
		String roomName = request.getParameter("roomName");
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		String memberPhone = request.getParameter("memberPhone");
		String RChkIn = request.getParameter("RChkIn");
		String RChkOut = request.getParameter("RChkOut");
		int RPersonCount = Integer.parseInt(request.getParameter("RPersonCount"));
		int RCount = Integer.parseInt(request.getParameter("RCount"));
		double addMLGDB = Double.parseDouble(request.getParameter("addMLG")) ;
		int addMLG = (int)Math.floor(addMLGDB);
		int minMLG = Integer.parseInt(request.getParameter("minMLG"));
		
		
		HttpSession session = request.getSession();
		int MNo = (int)session.getAttribute("no");
		RoomDTO room = new RoomDTO();
		
		room.setMNo(MNo);
		room.setMemberName(memberName);
		room.setRoomName(roomName);
		room.setTotalPrice(totalPrice);
		room.setMemberPhone(memberPhone);
		room.setRChkIn(RChkIn);
		room.setRChkOut(RChkOut);
		room.setRPersonCount(RPersonCount);
		room.setRCount(RCount);
		room.setAddMLG(addMLG);
		room.setMinMLG(minMLG);
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		int result = roomService.reserveEnroll(room);
		
		roomService.priceGrade(room);
		
		if(result > 0) {
			PrintWriter out = response.getWriter();
			out.print(result);

		}
		
		
	}

}

