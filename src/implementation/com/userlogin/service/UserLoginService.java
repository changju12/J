package implementation.com.userlogin.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import implementation.com.userlogin.dao.MemberDao;

public class UserLoginService {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	int user_lvl = 0;
	int row;

	public void getConnection() {
		try {
			// 드라이버 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521";
			String userId = "changju";
			String userPass = "changju";
			// 데이터 베이스 연결
			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);
			System.out.println("DB 연결 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}

	// 닫기
	private void close() {
		try {
			  if(rs != null)
				   rs.close();
			  if(conn != null)
				  conn.close();
			  if(stmt != null)
				  stmt.close();
			  if(pstmt != null)
				  pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void closePstmt() {
//		try {
//			rs.close();
//			conn.close();
//			pstmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// 멤버 전체 조회(관리자)
	public ArrayList<MemberDao> userList() {
		getConnection();

		MemberDao uservo = null;
		ArrayList<MemberDao> retArrlist = new ArrayList<MemberDao>();

		try {
			stmt = conn.createStatement();

			String sql = "SELECT  USER_ID, USER_PASS, USER_NAME, PHONE_NUM," + "ADDRESS, USER_LVL FROM USER_TB";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				uservo = new MemberDao();
				uservo.setUser_id(rs.getString("user_id"));
				uservo.setUser_pass(rs.getString("user_pass"));
				uservo.setUser_name(rs.getString("user_name"));
				uservo.setPhone_num(rs.getString("phone_num"));
				uservo.setAddress(rs.getString("address"));
				uservo.setUser_lvl(rs.getString("user_lvl"));

				retArrlist.add(uservo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return retArrlist;
	}


	// 회원 정보 수정(일반 사용자) // 
	public int updateUserInfo(MemberDao dao) {
		getConnection();
		try {

			String sql = "UPDATE USER_TB SET USER_PASS = ?, USER_NAME = ?, PHONE_NUM = ?, ADDRESS = ? WHERE USER_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dao.getUser_pass());
			pstmt.setString(2, dao.getUser_name());
			pstmt.setString(3, dao.getPhone_num());
			pstmt.setString(4, dao.getAddress());
			pstmt.setString(5, dao.getUser_id());

			int row = pstmt.executeUpdate();
			
			System.out.println(row);
			System.out.println("데이터 수정 성공!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			close();
		}
		return 1;
		
	}

	// 회원 등급 조정(관리자 ) // 수정중
	public int updateUserLvl(MemberDao dao) {
		getConnection();
		
		try {

			String sql = "UPDATE USER_TB SET USER_LVL = ? WHERE USER_ID = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dao.getUser_lvl());

			int row = pstmt.executeUpdate();
			System.out.println(row);
			System.out.println("데이터 입력 성공!");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

}
