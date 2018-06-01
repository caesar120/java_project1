/**
 * 파일명 : LoginDAO.java
 * 작성자 : 신동섭
 * 파일설명 : Login DAO 클래스
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.DBManager;

public class LoginDAO {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	// 신규 아이디 추가 메서드
	public boolean registerUser(LoginBean login) {
		conn = DBManager.getConnection();
		String sql = "insert into users " + " (user_id, passwd, user_name, email, phone, addr, gatepw ) "
				+ " values( ?, ?, ?, ?, ?, ?, ?)";
		// dept_seq.nextval=글번호 자동으로 찍히게 하는 시퀀스
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, login.getPasswd());
			pstmt.setString(3, login.getUserName());
			pstmt.setString(4, login.getEmail());
			pstmt.setString(5, login.getPhone());
			pstmt.setString(6, login.getAddr());
			pstmt.setString(7, login.getGatepw());
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

	// 회원정보 수정을 위한 아이디 단건 조회
	public LoginBean forModifyselUser(String user_id) {
		conn = DBManager.getConnection();

		String sql = "select user_id, user_name, passwd, email, phone, addr, gatepw from users where user_id=?";
		LoginBean login = new LoginBean();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			// 데이터가 하나만 있으므로 rs.next()를 한번만 실행 한다.
			rs.next();
			login.setUserId(rs.getString("user_id"));
			login.setUserName(rs.getString("user_name"));
			login.setPasswd(rs.getString("passwd"));
			login.setEmail(rs.getString("email"));
			login.setPhone(rs.getString("phone"));
			login.setAddr(rs.getString("addr"));
			login.setGatepw(rs.getString("gatepw"));
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
		return login;
	}

	// 아이디 조회를 위한(분실시) 아이디 단건 조회
	// 아이디 조회시 이메일과 유저이름이 필요함!
	public LoginBean selUser(String email, String user_name) {
		conn = DBManager.getConnection();

		String sql = "select user_id from users where email=? and user_name=?";
		LoginBean login = new LoginBean();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, user_name);
			ResultSet rs = pstmt.executeQuery();

			// 데이터가 하나만 있으므로 rs.next()를 한번만 실행 한다.
			rs.next();
			login.setUserId(rs.getString("user_id"));
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
		return login;
	}

	// 아이디 수정을 위한 매서드
	public boolean updateUser(LoginBean login) {
		conn = DBManager.getConnection();

		String sql = "update users set passwd=?, user_name=?, email=?, phone=?, addr=?, gatepw=? where user_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getPasswd());
			pstmt.setString(2, login.getUserName());
			pstmt.setString(3, login.getEmail());
			pstmt.setString(4, login.getPhone());
			pstmt.setString(5, login.getAddr());
			pstmt.setString(6, login.getGatepw());
			pstmt.setString(7, login.getUserId());
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

	// 특정 아이디 삭제 메서드
	public boolean deleteUser(String user_id) {
		conn = DBManager.getConnection();

		String sql = "delete from users where user_id=?";

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

	// 전체 유저 목록을 가져오는 메서드
	public ArrayList<LoginBean> userList() {
		conn = DBManager.getConnection();

		ArrayList<LoginBean> datas = new ArrayList<LoginBean>();

		String sql = "select user_id, user_name, email, phone, addr, gatepw from users order by user_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				LoginBean login = new LoginBean();
				login.setUserId(rs.getString("user_id"));
				login.setUserName(rs.getString("user_name"));
				login.setEmail(rs.getString("email"));
				login.setPhone(rs.getString("phone"));
				login.setAddr(rs.getString("addr"));
				login.setGatepw(rs.getString("gatepw"));
				datas.add(login);
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

	// 로그인 체크
	// userid, passwd 받아서
	// 일치하면 1
	// 아디가 없으면 0
	// 패스워드 안맞으면 -1
	public int loginCheck(LoginBean login) {
		int result = 0;
		try {
			conn = DBManager.getConnection();
			// sql명령
			String sql = "select user_id, passwd from users where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			// pstmt.setString(1, user_id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 패스워드 일치 검사
				String dbPasswd = rs.getString("passwd");
				if (dbPasswd.equals(login.getPasswd())) {
					result = 1; // 패스워드가 일치하는 경우
				} else {
					result = -1; // 패스워드가 틀린 경우
				}
			} else { // 아이디가 없는 경우
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
}
