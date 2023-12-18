package kr.co.project.room.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.room.model.dto.RoomDTO;
import kr.co.project.room.model.service.RoomServiceImpl;

@WebServlet("/foodListChk.do")
public class FoodListChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FoodListChkController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		RoomServiceImpl roomService = new RoomServiceImpl();
		RoomDTO basketGrade = roomService.memberMLGGradePercent(memberNo);
		
		ArrayList<RoomDTO> basketList = roomService.basketListView(memberNo);
		
		double percentMLG = 0;
		
		if(basketGrade.getMembership().equals("Silver")) {
			percentMLG = 0.03;
		}else if(basketGrade.getMembership().equals("Gold")) {
			percentMLG = 0.05;
		}else if(basketGrade.getMembership().equals("Platinum")) {
			percentMLG = 0.07;
		}else if(basketGrade.getMembership().equals("Black")) {
			percentMLG = 0.1;
		}else {
			percentMLG = 0;
		}
		
		
		
		request.setAttribute("percentMLG", percentMLG);
		request.setAttribute("basketList", basketList);
		request.setAttribute("basketGrade", basketGrade);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/room/basketList.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
