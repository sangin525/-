package kr.co.project.board.service;

import java.sql.Connection;

import kr.co.project.board.dao.BoardDAO;
import kr.co.project.common.DatabaseConnection;

public class BoardServiceImpl {
	private Connection con;
	private DatabaseConnection dc;
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		boardDAO = new BoardDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	
	
	
}
