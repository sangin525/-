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
	
}
