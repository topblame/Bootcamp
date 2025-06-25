package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_01 {
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			//1. JDBC 드라이버 로드 
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. Connection 읽기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system"; // 사용자 = 데이터베이스
			String password = "1234"; //
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스에 연동 성공.");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}//if
		}//finally
	}//main
}
