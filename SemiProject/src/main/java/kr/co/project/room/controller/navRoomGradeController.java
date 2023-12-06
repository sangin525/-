package kr.co.project.room.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/navRoomGrade.do")
public class navRoomGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public navRoomGradeController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String gradeMenu = request.getParameter("gradeMenu");
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		
		ArrayList<String> roomName = roomService.navRoomName(gradeMenu);
//		Map<String,String> map = new HashMap<String, String>();
		
//		for(RoomDTO item : roomName) {
//			map.put(gradeMenu, roomName.get())
//		}
		PrintWriter out = response.getWriter();
		out.print(roomName);
		out.close();
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
