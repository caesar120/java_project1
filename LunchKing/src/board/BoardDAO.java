package board;

import java.sql.*;
import java.util.*;

import util.DBManager;

/**
 * File : BoardDAO.java Desc : 게시판 DAO 클래스
 * 
 * @author 신동섭
 */
public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	// 신규 게시글 추가 메서드
	public boolean insertBoard(BoardBean board) {
		conn = DBManager.getConnection();
		String sql = "insert into board "
				+ " (board_id, title, board_type, viewcount, content, creationtime, user_id, board_image) "
				+ " values( (select nvl(max(board_id),0)+1 from board), ?, ?, ?, ?, sysdate, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getBoardType());
			pstmt.setString(4, board.getViewCount());
			pstmt.setString(5, board.getContent());
			pstmt.setString(6, board.getUserId());
			pstmt.setString(7, board.getBoardImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 게시글 수정을 위한 메서드
	public boolean updateBoard(BoardBean board) {
		conn = DBManager.getConnection();
		String sql = "update board set " + " title =?, " + " content =?, " + " board_image =?, " + " where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(1, board.getContent());
			pstmt.setString(3, board.getBoardImage());
			pstmt.setString(5, board.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 특정 게시글 게시글 삭제 메서드
	public boolean deleteBoard(String user_id) {
		conn = DBManager.getConnection();
		String sql = "delete from board where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 게시글 검색 조회
	public BoardBean selBoard(String title) { // 특정 키워드로 게시글 검색 메소드
		conn = DBManager.getConnection();
		String sql = " select board_id, title, board_type, viewcount, user_id from board "
				+ " where title like titile = ?";
		BoardBean board = new BoardBean();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			// 데이터가 하나만 있으므로 rs.next()를 한번만 실행 한다.
			board.setBoardId(rs.getString("Board_id"));
			board.setTitle(rs.getString("title"));
			board.setBoardType(rs.getString("board_type"));
			board.setViewCount(rs.getString("viewcount"));
			board.setUserId(rs.getString("user_id"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	// 전체 게시판 내용을 가져오는 메서드
	public ArrayList<BoardBean> selBoardList() {//게시판 검색시 내용 전체를 보여주는 메소드
		conn = DBManager.getConnection();

		ArrayList<BoardBean> datas = new ArrayList<BoardBean>();

		String sql = "select * from board order by board_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setBoardId(rs.getString("board_id"));
				board.setTitle(rs.getString("title"));
				board.setBoardType(rs.getString("boardType"));
				board.setViewCount(rs.getString("viewcount"));
				board.setContent(rs.getString("content"));
				board.setCreationTime(rs.getString("creationtime"));
				board.setUserId(rs.getString("user_id"));
				board.setBoardImage(rs.getString("board_image"));
				datas.add(board);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return datas;
	}
}