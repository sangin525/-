package kr.co.project.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.project.board.dao.BoardDAO;
import kr.co.project.board.dto.BoardDTO;
import kr.co.project.common.DatabaseConnection;
import kr.co.project.common.MyBoardPageInfo;

public class BoardServiceImpl implements BoardService {

	private Connection con;
	private DatabaseConnection dc;
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		boardDAO = new BoardDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	// 내 게시글 수 조회
	@Override
	public int myListCount(int no) {
		return boardDAO.myListCount(con, no);
	}

	// 내 게시글 목록 조회
	public ArrayList<BoardDTO> myBoardList(MyBoardPageInfo pi, int no){
		return boardDAO.myBoardList(con, pi, no);
	}
	
	
	
	
	
}
