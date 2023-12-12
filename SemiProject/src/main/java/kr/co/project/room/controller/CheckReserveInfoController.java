package kr.co.project.room.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/checkReserveInfo.do")
public class CheckReserveInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckReserveInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Rname = request.getParameter("Rname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		boolean checkInfo = roomService.checkInfo(Rname, startDate, endDate);
		PrintWriter out = response.getWriter();
		out.print(checkInfo);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
