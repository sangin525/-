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

@WebServlet("/MLGChk.do")
public class MLGChkcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MLGChkcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberMLG = Integer.parseInt(request.getParameter("memberMLG"));
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		RoomDTO mlgChk = roomService.MLGChkform(memberMLG, memberNo);
		PrintWriter out = response.getWriter();
		
		int DBMLG = mlgChk.getMLG();
		if(DBMLG == memberMLG) {
			out.print(true);
			out.close();
		}else {
			out.print(false);
			out.close();
		}
	}

}
























