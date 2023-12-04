package kr.co.project.room.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/DisableRoom.do")
public class DisableRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisableRoomController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomGrade = request.getParameter("roomGrade");
		HashSet<String> chkInOut = new HashSet<>();
		RoomServiceImpl roomService = new RoomServiceImpl();
		roomService.disableRoom(roomGrade, chkInOut);
		
		PrintWriter out = response.getWriter();
		out.print(chkInOut);
		out.close();
		
	}

}



























