package kr.co.project.notice.dto;

public class NoticeDTO {

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
	
	private int commentNo;
	private String commentContent;
	private String commentOnDate;
	private String commentInDate;
	private String commentDelete;
	private String commentWriter;

	
	
	private int no; // 게시글 번호
	private int m_No; // 작성자 번호
	private String delete; // 삭제일
	private String photo; // 사진이름
	private String route; // 사진경로
	
//	get,set 사용
	
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
	
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentOnDate() {
		return commentOnDate;
	}

	public void setCommentOnDate(String commentOnDate) {
		this.commentOnDate = commentOnDate;
	}

	public String getCommentInDate() {
		return commentInDate;
	}

	public void setCommentInDate(String commentInDate) {
		this.commentInDate = commentInDate;
	}

	public String getCommentDelete() {
		return commentDelete;
	}

	public void setCommentDelete(String commentDelete) {
		this.commentDelete = commentDelete;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public NoticeDTO() {
		super();
	}
	
	public NoticeDTO(int no, int m_No, String title, String content, String onDate, String inDate, String delete,
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
	
	public NoticeDTO(String title, String content, int boardNo) {
		super();
		this.title = title;
		this.content = content;
		this.boardNo = boardNo;
	}
	
	
}