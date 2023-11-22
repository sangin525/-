package kr.co.project.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.project.board.dao.BoardDAO;
import kr.co.project.board.dto.BoardDTO;
import kr.co.project.common.DatabaseConnection;

public class BoardServiceImpl implements BoardService{
	private Connection con;
	private DatabaseConnection dc;
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		boardDAO = new BoardDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	// 문의사항 생성
	public int boardEnroll(String title, String content, int memberNo) {
		return boardDAO.boardEnroll(con,title, content, memberNo);
	}
	
	// 공지사항 생성
	public int noticeEnroll(String title, String content, int memberNo) {
		return boardDAO.noticeEnroll(con, title, content, memberNo);
	}
	
	//게시글 목록 조회
	public ArrayList<BoardDTO> boardList(){
		return boardDAO.boardList(con);
	}
	
}
