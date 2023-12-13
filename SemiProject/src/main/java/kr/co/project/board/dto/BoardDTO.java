package kr.co.project.board.dto;

import java.util.List;

public class BoardDTO {

	private String title;
	private String content;

	private int boardNo;
	private int noticeNo;
	private String onDate;
	private String inDate;
	private String deleteDate;
	private int views;
	private String answer;

	private String name;
	
	//답변 DTO
	private int answerNo;
	private String answerContent;
	private String answerOnDate;
	private String answerInDate;
	private String answerDelete;
	private String answerWriter;

	
	
	private int no; // 게시글 번호
	private int m_No; // 작성자 번호
	private String delete; // 삭제일
	private String photo; // 사진이름
	private String route; // 사진경로
	
	

	// 리뷰 DTO
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String reviewTitle;
	private String reviewContent;
	private String reviewNo;
	private String room;
	private String year;
	private String month;
	private String type;
	private String star;
	private String reviewInDate;
	private String reviewUpdateDate;
	private String reviewDeleteDate;
	private List<String> reviewPhotos;
	private String reviewRoute1;


	private String Checkbox; // 문의사항 체크박스
	private String categoty; // 카테고리 분류



//	get,set 사용
	
	
	
	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getReviewInDate() {
		return reviewInDate;
	}

	public void setReviewInDate(String reviewInDate) {
		this.reviewInDate = reviewInDate;
	}

	public String getReviewUpdateDate() {
		return reviewUpdateDate;
	}

	public void setReviewUpdateDate(String reviewUpdateDate) {
		this.reviewUpdateDate = reviewUpdateDate;
	}

	public String getReviewDeleteDate() {
		return reviewDeleteDate;
	}

	public void setReviewDeleteDate(String reviewDeleteDate) {
		this.reviewDeleteDate = reviewDeleteDate;
	}

	public List<String> getReviewPhotos() {
		return reviewPhotos;
	}

	public void setReviewPhotos(List<String> reviewPhotos) {
		this.reviewPhotos = reviewPhotos;
	}

	public String getReviewRoute1() {
		return reviewRoute1;
	}

	public void setReviewRoute1(String reviewRoute1) {
		this.reviewRoute1 = reviewRoute1;
	}

	public String getTitle() {
		return title;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}




	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getOnDate() {
		return onDate;
	}

	public void setOnDate(String onDate) {
		this.onDate = onDate;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getM_No() {
		return m_No;
	}

	public void setM_No(int m_No) {
		this.m_No = m_No;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerOnDate() {
		return answerOnDate;
	}

	public void setAnswerOnDate(String answerOnDate) {
		this.answerOnDate = answerOnDate;
	}

	public String getAnswerInDate() {
		return answerInDate;
	}

	public void setAnswerInDate(String answerInDate) {
		this.answerInDate = answerInDate;
	}

	public String getAnswerDelete() {
		return answerDelete;
	}

	public void setAnswerDelete(String answerDelete) {
		this.answerDelete = answerDelete;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}
	
	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getCheckbox() {
		return Checkbox;
	}

	public String getCategoty() {
		return categoty;
	}

	public void setCategoty(String categoty) {
		this.categoty = categoty;
	}

	public void setCheckbox(String checkbox) {
		Checkbox = checkbox;
	}

	public BoardDTO() {
		super();
	}
	
	public BoardDTO(int no, int m_No, String title, String content, String onDate, String inDate, String delete,
			int views, String photo, String route, String answer) {
		super();
		this.no = no;
		this.m_No = m_No;
		this.title = title;
		this.content = content;
		this.onDate = onDate;
		this.inDate = inDate;
		this.delete = delete;
		this.views = views;
		this.photo = photo;
		this.route = route;
		this.answer = answer;
	}
	
	public BoardDTO(String title, String content, int boardNo) {
		super();
		this.title = title;
		this.content = content;
		this.boardNo = boardNo;
	}

	public BoardDTO(String id, String reviewTitle, String reviewContent, String reviewNo, String room, String year,
			String month, String type, String star, String reviewInDate, String reviewUpdateDate,
			String reviewDeleteDate, List<String> reviewPhotos, String reviewRoute1) {
		super();
		this.id = id;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewNo = reviewNo;
		this.room = room;
		this.year = year;
		this.month = month;
		this.type = type;
		this.star = star;
		this.reviewInDate = reviewInDate;
		this.reviewUpdateDate = reviewUpdateDate;
		this.reviewDeleteDate = reviewDeleteDate;
		this.reviewPhotos = reviewPhotos;
		this.reviewRoute1 = reviewRoute1;
	}
	
	
}