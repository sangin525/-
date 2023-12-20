package kr.co.project.notice.service;

import java.util.ArrayList;

import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.notice.dto.NoticeDTO;

public interface NoticeService {
	
	// 공지사항 생성 (Notice)
	public int noticeEnroll(String title,String content, int memberNo,String fileName,String uploadDirectory);
	// 공지사항 List up
	public ArrayList<NoticeDTO> noticeList(BoardPageInfo pi);
	// 공지사항 전체 게시글 수
	public int noticeListCount();
	// 공지사항 조회수 증가
	public int noticeView(int boardNo);
	// 공지사항 상세보기
	public void noticeSelect(NoticeDTO notice);
	// 공지사항 수정
	public int noticeUpdate(NoticeDTO notice);
	//공지사항 삭제
	public int noticeDelete(int BoardNo);
	// 답변 추가
	public int commentEnroll(String comment,String name, int boardNo);
	// 답변 수정
	public int commentDetailUpdate(String content, int commentNo);
	// 답변 삭제
	public int commentDelete(int commentNo);
	// 공지사항 검색
	public int noticeSearchCount(String SearchName);
	// 공지사항 검색
	public ArrayList<NoticeDTO> noticeSearchList(BoardPageInfo pi, String SearchName);
}
