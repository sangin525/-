package kr.co.project.notice.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.common.DatabaseConnection;
import kr.co.project.notice.dao.NoticeDAO;
import kr.co.project.notice.dto.NoticeDTO;

public class NoticeServiceImpl implements NoticeService{
	private Connection con;
	private DatabaseConnection dc;
	private NoticeDAO noticeDAO;
	
	public NoticeServiceImpl() {
		noticeDAO = new NoticeDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	// 공지사항 생성
	public int noticeEnroll(String title,String content, int memberNo,String fileName,String uploadDirectory) {
		return noticeDAO.noticeEnroll(con, title, content, memberNo, fileName, uploadDirectory);
	}
	
	// 공지사항 목록 조회
	public ArrayList<NoticeDTO> noticeList(BoardPageInfo pi){
		return noticeDAO.noticeList(con, pi);
	}
	
	// 공지사항 전체 게시글 수
	public int noticeListCount() {
		return noticeDAO.noticeListCount(con);
	}
	// 공지 사항 조회수 증가
	public int noticeView(int boardNo){
		return noticeDAO.noticeView(con, boardNo);
	}
	// 공지 사항 상세 보기
	@Override
	public void noticeSelect(NoticeDTO notice) {
		noticeDAO.noticeSelect(con, notice);
	}
	
	// 공지사항 수정
	public int noticeUpdate(NoticeDTO notice) {
		return noticeDAO.noticeUpdate(con,notice);
	}
	//공지사항 삭제
	public int noticeDelete(int BoardNo) {
		return noticeDAO.noticeDelete(con, BoardNo);
	}
	// 답변 추가
	public int commentEnroll(String comment,String name, int boardNo) {
		return noticeDAO.commentEnroll(con, comment, name, boardNo);
	}
	// 답변 수정
	public int commentDetailUpdate(String content, int commentNo) {
		return noticeDAO.commentDetailUpdate(con, content, commentNo);
	}
	// 답변 삭제
	public int commentDelete(int commentNo) {
		return noticeDAO.commentDelete(con, commentNo);
	}
	// 공지사항 검색 전체 게시글 수
	public int noticeSearchCount(String SearchName) {
		return noticeDAO.noticeSearchCount(con, SearchName);
	}
	// 공지사항 검색
	public ArrayList<NoticeDTO> noticeSearchList(BoardPageInfo pi, String SearchName){
		return noticeDAO.noticeSearchList(con, pi, SearchName);
	}
	
}
