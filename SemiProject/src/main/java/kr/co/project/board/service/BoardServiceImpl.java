package kr.co.project.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.project.board.dao.BoardDAO;
import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.common.DatabaseConnection;
import kr.co.project.common.MyBoardPageInfo;

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
	public ArrayList<BoardDTO> boardList(BoardPageInfo pi){
		return boardDAO.boardList(con, pi);
	}
	// 공지사항 목록 조회
	public ArrayList<BoardDTO> noticeList(){
		return boardDAO.noticeList(con);
	}
	// 문의사항 상세보기
	public int boardView(int boardNo){
		return boardDAO.boardView(con, boardNo);
	}
	
	@Override
	public void boardSelect(BoardDTO board) {
		boardDAO.boardSelect(con, board);
	}
	
	// 문의사항 수정
	public int boardUpdate(BoardDTO board) {
		return boardDAO.boardUpdate(con,board);
	}
	
	// 문의사항 삭제
	public int boardDelete(int BoardNo) {
		return boardDAO.boardDelete(con, BoardNo);
	}
	
	// 문의사항 전체 게시글 수
	public int boardListCount() {
		return boardDAO.boardListCount(con);
	}
	// 답변 추가
	public int answerEnroll(String answer,String name, int boardNo) {
		return boardDAO.answerEnroll(con, answer, name, boardNo);
	}
	// 답변 추가 시 답변 여부 업데이트
	public int answerUpdate(int boardNo) {
		return boardDAO.answerUpdate(con, boardNo);
	}
	// 답변 수정
	public int answerDetailUpdate(String content, int answerNo) {
		return boardDAO.answerDetailUpdate(con, content, answerNo);
	}
	// 답변 삭제
	public int answerDelete(int answerNo) {
		return boardDAO.answerDelete(con, answerNo);
	}
	// 답변 삭제 시 답변 여부 업데이트
	public int answerDeleteUpdate(int boardNo) {
		return boardDAO.answerDeleteUpdate(con, boardNo);
	}
	
	// 마이페이지
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
