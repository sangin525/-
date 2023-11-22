package kr.co.project.reserve.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.project.common.DatabaseConnection;
import kr.co.project.common.MyBoardPageInfo;
import kr.co.project.reserve.dao.MyReserveDAO;
import kr.co.project.reserve.dto.MyReserveDTO;

public class MyReserveServiceImpl implements MyReserveService {
	private Connection con;
	private DatabaseConnection dc;
	private MyReserveDAO reserveDAO;

	public MyReserveServiceImpl() {
		reserveDAO = new MyReserveDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	// 내 예약 수 조회
	@Override
	public int myListCount(int no) {
		return reserveDAO.myListCount(con, no);
	}
	
	// 내 게시글 목록 조회
	public ArrayList<MyReserveDTO> myReserveList(MyBoardPageInfo pi, int no) {
		return reserveDAO.myReserveList(con, pi, no);
	}
	
}
