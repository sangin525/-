package kr.co.project.board.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.board.page.ReviewPageInfo;
import kr.co.project.common.MyBoardPageInfo;

public class BoardDAO {

	private PreparedStatement pstmt;

	// 문의사항 작성
	public int boardEnroll(Connection con, String title, String content, int memberNo, String fileName, String uploadDirectory, String categoryHidden, String secretBox) {
	    String query = "INSERT INTO BOARD" +
	            " VALUES(board_seq.nextval," + // BOARD_NO
	            " ?," + // M_NO
	            " ?," + // BOARD_TITLE
	            " ?," + // BOARD_CONTENT
	            " SYSDATE," + // BOARD_ON_DATE
	            " NULL," + // BOARD_IN_DATE
	            " NULL," + // BOARD_DELETE
	            " 0," + // BOARD_VIEWS
	            " ?," + // BOARD_PHOTO
	            " ?," + // BOARD_ROUTE
	            " 'N'," + // BOARD_ANSWER
	            " ?," + // BOARD_CATEGORY
	            " ?)"; //BOARD_SECRET

	    try {
	        pstmt = con.prepareStatement(query);

	        pstmt.setInt(1, memberNo);
	        pstmt.setString(2, title);
	        pstmt.setString(3, content);
	        pstmt.setString(4, fileName);
	        pstmt.setString(5, uploadDirectory);
	        pstmt.setString(6, categoryHidden);
	        pstmt.setString(7, secretBox);

	        int result = pstmt.executeUpdate();

	        pstmt.close();
	        con.close();

	        return result;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}


	// boardList 가져오기
	public ArrayList<BoardDTO> boardList(Connection con, BoardPageInfo pi) {
		ArrayList<BoardDTO> list = new ArrayList<>();

		String query = "SELECT B.BOARD_NO, "
		        + "B.BOARD_TITLE, "
		        + "B.BOARD_ON_DATE, "
		        + "B.BOARD_VIEWS, "
		        + "B.BOARD_ANSWER, "
		        + "B.BOARD_CATEGORY, "
		        + "B.BOARD_SECRET, "
		        + "M.M_NO, "
		        + "M.M_NAME "
		        + "FROM BOARD B "
		        + "INNER JOIN MEMBER M ON B.M_NO = M.M_NO "
		        + "WHERE B.BOARD_DELETE IS NULL "
		        + "ORDER BY B.BOARD_ON_DATE DESC "
		        + "OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, pi.getOffset());
			pstmt.setInt(2, pi.getBoardLimit()); // 5
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int boardNo = rs.getInt("Board_NO");
				String title = rs.getString("BOARD_TITLE");
				String onDate = rs.getString("BOARD_ON_DATE");
				int views = rs.getInt("BOARD_VIEWS");
				String answer = rs.getString("BOARD_ANSWER");
				String category = rs.getString("BOARD_CATEGORY");
				String secret = rs.getString("BOARD_SECRET");
				int m_No = rs.getInt("M_NO");
				String name = rs.getString("M_NAME");

				BoardDTO board = new BoardDTO();

				board.setBoardNo(boardNo);
				board.setTitle(title);
				board.setOnDate(onDate);
				board.setViews(views);
				board.setAnswer(answer);
				board.setCategoty(category);
				board.setSecret(secret);
				board.setM_No(m_No);
				board.setName(name);

				list.add(board);

			}
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 조회수 증가
	public int boardView(Connection con, int boardNo) {
		String query = "UPDATE BOARD"
				+ "		SET BOARD_VIEWS = BOARD_VIEWS+1"
				+ "		WHERE BOARD_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,boardNo);
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	// board detail 공지사항 상세보기
	public void boardSelect(Connection con, BoardDTO board) {
		String query = "SELECT B.BOARD_NO, "
		        + "B.BOARD_TITLE, "
		        + "B.BOARD_CONTENT, "
		        + "B.BOARD_IN_DATE, "
		        + "B.BOARD_VIEWS, "
		        + "B.BOARD_PHOTO,"
		        + "B.BOARD_ROUTE,"
		        + "B.BOARD_ANSWER, "
		        + "M.M_NO, "
		        + "M.M_NAME, "
		        + "A.ANSWER_NO, "
		        + "A.ANSWER_CONTENT, "
		        + "A.ANSWER_ON_DATE, "
		        + "A.ANSWER_IN_DATE, "
		        + "A.ANSWER_WRITER "
		        + "FROM BOARD B "
		        + "INNER JOIN MEMBER M ON B.M_NO = M.M_NO "
		        + "LEFT JOIN ANSWER A ON B.BOARD_NO = A.BOARD_NO AND A.ANSWER_DELETE IS NULL "
		        + "WHERE B.BOARD_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, board.getBoardNo());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String title = rs.getString("BOARD_TITLE");
				String content = rs.getString("BOARD_CONTENT");
				String inDate = rs.getString("BOARD_IN_DATE");
				int views = rs.getInt("BOARD_VIEWS");
				String photo = rs.getString("BOARD_PHOTO");
				String route = rs.getString("BOARD_ROUTE");
				String answer = rs.getString("BOARD_ANSWER");
				String name = rs.getString("M_NAME");
				int m_No = rs.getInt("M_NO");
				int answerNo = rs.getInt("ANSWER_NO");
				String answerContent = rs.getString("ANSWER_CONTENT");
				String answerOnDate = rs.getString("ANSWER_ON_DATE");
				String answerInDate = rs.getString("ANSWER_IN_DATE");
				String answerWriter = rs.getString("ANSWER_WRITER");
				
				board.setBoardNo(boardNo);
				board.setTitle(title);
				board.setContent(content);
				board.setInDate(inDate);
				board.setViews(views);
				board.setPhoto(photo);
				board.setRoute(route);
				board.setAnswer(answer);
				board.setName(name);
				board.setM_No(m_No);
				board.setAnswerNo(answerNo);
				board.setAnswerContent(answerContent);
				board.setAnswerOnDate(answerOnDate);
				board.setAnswerInDate(answerInDate);
				board.setAnswerWriter(answerWriter);
				
			}
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 문의사항 수정
	public int boardUpdate(Connection con, BoardDTO board) {
		String query = "UPDATE BOARD"
				+ "	SET	BOARD_TITLE = ?,"
				+ "		BOARD_CONTENT =?,"
				+ "		BOARD_IN_DATE =SYSDATE, "
				+ "		BOARD_SECRET = ? "
				+ "		WHERE BOARD_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getSecret());
			pstmt.setInt(4, board.getBoardNo());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	// 문의게시판 삭제 
	public int boardDelete(Connection con, int boardNo) {
		String query = "UPDATE BOARD"
				+ "		SET BOARD_DELETE = SYSDATE"
				+ "		WHERE BOARD_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, boardNo);
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//전체 게시글 수
	public int boardListCount(Connection con) {
		String query = "SELECT count(*) AS cnt"
				+ "		FROM BOARD"
				+ "		WHERE BOARD_DELETE IS NULL";
		
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	//공지사항 답변 추가
	public int answerEnroll(Connection con, String answer,String name, int boardNo) {
	    String query = "INSERT INTO ANSWER VALUES" 
	            + " (answer_seq.nextval, " // answer NO
	            + " ?, " // Board NO
	            + " ?, " // ANSWER_CONTENT
	            + " SYSDATE, " // ANSWER_ON_DATE
	            + " NULL, " // ANSWER_IN_DATE
	            + " NULL, " // ANSWER_DELETE
	            + " ?)"; // ANSWER_WRITER
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,boardNo);
			pstmt.setString(2, answer);
			pstmt.setString(3, name);
			
			int result = pstmt.executeUpdate();
			

			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	// 답변 추가 시 list에 답변 여부 Y로 변경
	public int answerUpdate(Connection con, int boardNo) {
	    String query = "UPDATE BOARD SET BOARD_ANSWER = 'Y' WHERE BOARD_NO = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return 0;
	}
	// 답변 수정
	public int answerDetailUpdate(Connection con, String content, int answerNo) {
		String query = "UPDATE ANSWER SET ANSWER_CONTENT = ?, ANSWER_IN_DATE = SYSDATE WHERE ANSWER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setInt(2, answerNo);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	//답변 삭제
	public int answerDelete(Connection con, int answerNo) {
		String query = "UPDATE ANSWER SET ANSWER_DELETE = SYSDATE WHERE ANSWER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, answerNo);
			
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	// 답변 삭제 시 답변 여부 업데이트
	public int answerDeleteUpdate(Connection con, int boardNo) {
		String query = "UPDATE BOARD SET BOARD_ANSWER = 'N' WHERE BOARD_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, boardNo);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	// board에 카테고리 분류
	public ArrayList<BoardDTO> boardCategoryList(Connection con, BoardPageInfo pi, String category) {
		ArrayList<BoardDTO> categoryItem = new ArrayList<>();

		String query = "SELECT B.BOARD_NO, "
		        + "B.BOARD_TITLE, "
		        + "B.BOARD_ON_DATE, "
		        + "B.BOARD_VIEWS, "
		        + "B.BOARD_ANSWER, "
		        + "B.BOARD_CATEGORY, "
		        + "B.BOARD_SECRET, "
		        + "M.M_NO, "
		        + "M.M_NAME "
		        + "FROM BOARD B "
		        + "INNER JOIN MEMBER M ON B.M_NO = M.M_NO "
		        + "WHERE B.BOARD_DELETE IS NULL "
		        + "AND B.BOARD_CATEGORY = ?"
		        + "ORDER BY B.BOARD_ON_DATE DESC "
		        + "OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, category);
			pstmt.setInt(2, pi.getOffset());
			pstmt.setInt(3, pi.getBoardLimit()); // 5
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int boardNo = rs.getInt("Board_NO");
				String title = rs.getString("BOARD_TITLE");
				String onDate = rs.getString("BOARD_ON_DATE");
				int views = rs.getInt("BOARD_VIEWS");
				String answer = rs.getString("BOARD_ANSWER");
				String selectCategory = rs.getString("BOARD_CATEGORY");
				String secret = rs.getString("BOARD_SECRET");
				
				int m_No = rs.getInt("M_NO");
				String name = rs.getString("M_NAME");

				BoardDTO board = new BoardDTO();

				board.setBoardNo(boardNo);
				board.setTitle(title);
				board.setOnDate(onDate);
				board.setViews(views);
				board.setAnswer(answer);
				board.setM_No(m_No);
				board.setName(name);
				board.setCategoty(selectCategory);
				board.setSecret(secret);

				categoryItem.add(board);

			}
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryItem;
	}
	
	//카테고리 게시글 수
	public int boardCategoryListCount(Connection con, String category) {
		String query = "SELECT count(*) AS cnt"
				+ "		FROM BOARD"
				+ "		WHERE BOARD_DELETE IS NULL"
				+ "		AND BOARD_CATEGORY = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, category);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	// 문의사항 검색내용 List up
	public ArrayList<BoardDTO> boardSearchList(Connection con, BoardPageInfo pi, String SearchName) {
		ArrayList<BoardDTO> list = new ArrayList<>();

		String query = "SELECT B.BOARD_NO, "
		        + "B.BOARD_TITLE, "
		        + "B.BOARD_ON_DATE, "
		        + "B.BOARD_VIEWS, "
		        + "B.BOARD_ANSWER, "
		        + "B.BOARD_CATEGORY, "
		        + "B.BOARD_SECRET, "
		        + "M.M_NO, "
		        + "M.M_NAME "
		        + "FROM BOARD B "
		        + "INNER JOIN MEMBER M ON B.M_NO = M.M_NO "
		        + "WHERE B.BOARD_DELETE IS NULL "
		        + "AND UPPER(B.BOARD_TITLE) LIKE ? "
		        + "ORDER BY B.BOARD_ON_DATE DESC "
		        + "OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "%" + SearchName + "%");
			pstmt.setInt(2, pi.getOffset());
			pstmt.setInt(3, pi.getBoardLimit()); // 5
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int boardNo = rs.getInt("Board_NO");
				String title = rs.getString("BOARD_TITLE");
				String onDate = rs.getString("BOARD_ON_DATE");
				int views = rs.getInt("BOARD_VIEWS");
				String answer = rs.getString("BOARD_ANSWER");
				String category = rs.getString("BOARD_CATEGORY");
				String secret = rs.getString("BOARD_SECRET");
				int m_No = rs.getInt("M_NO");
				String name = rs.getString("M_NAME");

				BoardDTO board = new BoardDTO();

				board.setBoardNo(boardNo);
				board.setTitle(title);
				board.setOnDate(onDate);
				board.setViews(views);
				board.setAnswer(answer);
				board.setCategoty(category);
				board.setSecret(secret);
				board.setM_No(m_No);
				board.setName(name);

				list.add(board);

			}
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//검색 전체 페이징 처리 수
	public int boardSearchCount(Connection con, String SearchName) {
		String query = "SELECT count(*) AS cnt"
				+ "		FROM BOARD"
				+ "		WHERE BOARD_DELETE IS NULL"
				+ "		AND UPPER(BOARD_TITLE) LIKE ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "%" + SearchName + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	// 마이페이지
	
		// 내 게시글 목록 불러오기
		public ArrayList<BoardDTO> myBoardList(Connection con, MyBoardPageInfo pi, int no) {

			ArrayList<BoardDTO> list = new ArrayList<>();
			
			String query = "SELECT board_no,"
					+ "			   board_title,"
					+ "			   board_on_date,"
					+ "			   board_views,"
					+ "			   board_answer"
					+ "		FROM board"
					+ "		WHERE board_delete IS NULL"
					+ "		AND M_NO = ?"
					+ "		ORDER BY board_on_date DESC"
					+ "		OFFSET ? ROW FETCH FIRST ? ROWS ONLY";
			
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1, no);
				pstmt.setInt(2, pi.getOffset());
				pstmt.setInt(3, pi.getBoardLimit());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int b_no = rs.getInt("BOARD_NO");
					String title = rs.getString("BOARD_TITLE");
					String onDate = rs.getString("BOARD_ON_DATE");
					int views = rs.getInt("BOARD_VIEWS");
					String answer = rs.getString("BOARD_ANSWER");
					
					BoardDTO board = new BoardDTO();
					board.setNo(b_no);
					board.setTitle(title);
					board.setOnDate(onDate);
					board.setViews(views);
					board.setAnswer(answer);
					
					list.add(board);
					
				}

				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
			return list;
		}
		
		
		
		// 내 게시글 수 조회
		public int myListCount(Connection con, int no) {

			// 쿼리작성
			String query = "SELECT count(*) as cnt"
					+ "		FROM board"
					+ "		WHERE board_delete IS NULL"
					+ "		AND M_NO = ?";
			// 실행준비
			try {
				pstmt = con.prepareStatement(query);
				// 물음표 채우고
				pstmt.setInt(1, no);
				// 실행
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int result = rs.getInt("CNT");
					return result;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return 0;
		
		
	}

		// 리뷰 작성
		public int reviewEnroll(Connection con, BoardDTO board, int no) {
			String uploadDirectory = "C:\\Users\\USER\\git\\SemiProject\\SemiProject\\src\\main\\webapp\\resources\\uploads\\review";
		    String query = "INSERT INTO review"
		            + "        VALUES(REVIEW_SEQ.nextval,"
		            + "                ?,"
		            + "                ?,"
		            + "                ?,"
		            + "                ?,"
		            + "                ?,"
		            + "                ?,"
		            + "                ?,"
		            + "                sysdate,"
		            + "                null,"
		            + "                null,"
		            + "                ?)";
		    try {
		        pstmt = con.prepareStatement(query, new String[] {"REVIEW_NO"});
		        pstmt.setString(1, board.getReviewTitle());
		        pstmt.setString(2, board.getReviewContent());
		        pstmt.setString(3, board.getRoom());
		        pstmt.setString(4, board.getYear());
		        pstmt.setString(5, board.getMonth());
		        pstmt.setString(6, board.getType());
		        pstmt.setString(7, board.getStar());
		        pstmt.setInt(8, no);
		        pstmt.executeUpdate();

		        ResultSet rs = pstmt.getGeneratedKeys();
		        if (rs.next()) {
		            int reviewNo = rs.getInt(1);  // 기본 키 값을 정수로 변환합니다.
		            board.setReviewNo(reviewNo);  // board 객체의 reviewNo 필드에 저장합니다.
		        }

		        rs.close();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    List<String> fileNames = board.getFileNames();  // board 객체에서 파일명 리스트를 가져옵니다.

		    String photo = "INSERT INTO review_photo"
		            + "        VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    try {
		        pstmt = con.prepareStatement(photo);
		        pstmt.setInt(1, board.getReviewNo());
		        for(int i=0; i<fileNames.size(); i++) {  // 파일명 리스트의 크기만큼 반복합니다.
		            pstmt.setString(2 + 2*i, fileNames.get(i));  // 파일명을 저장합니다.
		            pstmt.setString(3 + 2*i, uploadDirectory + File.separator + fileNames.get(i));  // 파일 경로를 저장합니다.
		        }
		        
		        for(int i=fileNames.size(); i<5; i++) {  // 나머지 필드는 null로 설정합니다.
		            pstmt.setString(2 + 2*i, null);
		            pstmt.setString(3 + 2*i, null);
		        }

		        int result = pstmt.executeUpdate();
		        pstmt.close();

		        return result;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return 0;
		}


		// 리뷰 리스트
		public ArrayList<BoardDTO> reviewList(Connection con, ReviewPageInfo pi) {
			// 1. 쿼리작성
			String query = "SELECT r.review_no, m.m_id, to_char(r.review_in_date, 'yyyy-mm-dd') as review_in_date, r.review_title, r.review_content, r.review_star"
			        + " FROM review r"
			        + " JOIN MEMBER m"
			        + " ON m.m_no = r.m_no"
			        + " WHERE r.review_delete_date is null"
			        + " ORDER BY r.review_in_date DESC "
			        + " OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			
			ArrayList<BoardDTO> list = new ArrayList<>();

			try {
			    pstmt = con.prepareStatement(query);
			    pstmt.setInt(1, pi.getOffset());
			    pstmt.setInt(2, pi.getBoardLimit()); // 5

			    ResultSet rs = pstmt.executeQuery();

			    while (rs.next()) {
			        String m_id = rs.getString("M_ID");
			        String inDate = rs.getString("REVIEW_IN_DATE");
			        String title = rs.getString("REVIEW_TITLE");
			        String content = rs.getString("REVIEW_CONTENT");
			        String star = rs.getString("REVIEW_STAR");

			        int reviewNo = rs.getInt("REVIEW_NO");  // 각 리뷰의 번호를 가져옵니다.
			        List<String> fileNames = getReviewPhotos(con, reviewNo);  // getReviewPhotos 메서드를 호출하여 사진 경로 리스트를 가져옵니다.

			        BoardDTO board = new BoardDTO();
			        board.setReviewNo(reviewNo);
			        board.setId(m_id);
			        board.setReviewInDate(inDate);
			        board.setReviewTitle(title);
			        board.setReviewContent(content);
			        board.setFileNames(fileNames);  // BoardDTO 객체에 사진 경로 리스트를 설정합니다.
			        board.setStar(star);

			        list.add(board);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}

			return list;
		}
		// 전체 리뷰 수 조회
		public int reviewListCount(Connection con) {
			String query = "SELECT count(*) as cnt"
					+ "		FROM review"
					+ "		WHERE review_delete_date IS NULL";
					
			// 실행준비
						try {
							pstmt = con.prepareStatement(query);
							// 실행
							
							ResultSet rs = pstmt.executeQuery();
							
							while(rs.next()) {
								int result = rs.getInt("CNT");
								return result;
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						return 0;
		}

		public List<String> getReviewPhotos(Connection con, int reviewNo) {
		    String query = "SELECT photo1_route, photo2_route, photo3_route,"
		            + "       photo4_route, photo5_route, photo1_name, photo2_name, photo3_name,"
		            + "		  photo4_name, photo5_name"
		            + " FROM review_photo"
		            + " WHERE review_no = ?";  // reviewNo를 사용하여 해당 리뷰의 사진만 선택하도록 합니다.

		    List<String> photoList = new ArrayList<>();  // 결과를 저장할 리스트를 생성합니다.

		    try {
		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setInt(1, reviewNo);
		        ResultSet rs = pstmt.executeQuery();

		        while (rs.next()) {
		            for (int i = 1; i <= 5; i++) {
		                String photoName = rs.getString("photo" + i+"_name");
		                if (photoName != null && !photoName.isEmpty()) {
		                    String photoPath = photoName;
		                    photoList.add(photoPath);
		                }
		            }
		        }
		        rs.close();
		        pstmt.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return photoList;  // 사진 경로 리스트를 반환합니다.
		}

		//리뷰 삭제
		public int reviewDelete(Connection con, int reviewNo) {
		    String query = "UPDATE review set review_delete_date = sysdate where review_no = ?";
		    
		    try {
		    	
		        pstmt = con.prepareStatement(query);
		        
		        pstmt.setInt(1, reviewNo);
		        
		        int result = pstmt.executeUpdate();

		        return result;
		        
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    
		    return 0;
		}
	
		// 리뷰 업데이트
		public int reviewUpdate(Connection con, BoardDTO board, int reviewNo) {
			String uploadDirectory = "C:\\Users\\kaw19\\git\\SemiProject\\SemiProject\\src\\main\\webapp\\resources\\uploads\\review";
		    String query = "Update review set review_title = ?,"
		    		+ "						review_content = ?,"
		    		+ "						review_room = ?,"
		    		+ "						review_year = ?,"
		    		+ "						review_month = ?,"
		    		+ "						review_type = ?,"
		    		+ "						review_star = ?,"
		    		+ "						review_update_date = sysdate"
		    		+ "					where review_no = ?";
		           
		    try {
		        pstmt = con.prepareStatement(query, new String[] {"REVIEW_NO"});
		        pstmt.setString(1, board.getReviewTitle());
		        pstmt.setString(2, board.getReviewContent());
		        pstmt.setString(3, board.getRoom());
		        pstmt.setString(4, board.getYear());
		        pstmt.setString(5, board.getMonth());
		        pstmt.setString(6, board.getType());
		        pstmt.setString(7, board.getStar());
		        pstmt.setInt(8, reviewNo);
		        pstmt.executeUpdate();

		        

		       

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    List<String> fileNames = board.getFileNames();  // board 객체에서 파일명 리스트를 가져옵니다.

		    String photo = "UPDATE review_photo set "
		            + "       photo1_name = ?,"
		            + "			photo1_route = ?,"
		            + "			photo2_name = ?,"
		            + "			photo2_route = ?,"
		            + "			photo3_name = ?,"
		            + "			photo3_route = ?,"
		            + "			photo4_name = ?,"
		            + "			photo4_route = ?,"
		            + "			photo5_name = ?,"
		            + "			photo5_route = ?"
		            + "		where review_no =?";
		    try {
		        pstmt = con.prepareStatement(photo);
		        for(int i=0; i<fileNames.size(); i++) {  // 파일명 리스트의 크기만큼 반복합니다.
		            pstmt.setString(1 + 2*i, fileNames.get(i));  // 파일명을 저장합니다.
		            pstmt.setString(2 + 2*i, uploadDirectory + File.separator + fileNames.get(i));  // 파일 경로를 저장합니다.
		        }
		        
		        for(int i=fileNames.size(); i<5; i++) {  // 나머지 필드는 null로 설정합니다.
		            pstmt.setString(1 + 2*i, null);
		            pstmt.setString(2 + 2*i, null);
		        }
		        pstmt.setInt(11, reviewNo);
		        int result = pstmt.executeUpdate();
		        pstmt.close();

		        return result;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return 0;
		}
			
}
