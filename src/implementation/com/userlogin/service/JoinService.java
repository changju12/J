package implementation.com.userlogin.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import implementation.com.userlogin.dao.MemberDao;

public class JoinService {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	public JoinService(){}
	
	public int idchk(String id){
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
		String SQL = "SELECT * FROM USER_TB WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				System.out.println("사용불가");
				return 0;
			}else{
				System.out.println("사용가능");
				return 1;
			}
		} catch (SQLException e) {
			System.out.println("오류2");
			e.printStackTrace();
		} finally{
			try{
				if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(conn != null){conn.close();}
			}catch(Exception e){
				System.out.println("오류3");
			}
		}
		
		return -1;
	}
	public void join(MemberDao dao) {
		try {
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
			
			String sql = "INSERT INTO BOARD_USER_TB(USER_ID,USER_PASS,USER_NAME,PHONE_NUM,ADDRESS,USER_LVL) VALUES(?, ?, ?, ?, ?)";
			// 데이터베이스 접속
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dao.getUser_id());
			pstmt.setString(2, dao.getUser_pass());
			pstmt.setString(3, dao.getUser_name());
			pstmt.setString(4, dao.getPhone_num());
			pstmt.setString(5, dao.getAddress());
			
			//pstmt.setDate(index, java.sql.Date.valueOf("YYYY-MM-DD"));
			int row = pstmt.executeUpdate();
			System.out.println(row);
			System.out.println("데이터 입력 성공!");
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
}
