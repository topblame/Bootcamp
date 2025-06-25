package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAdd_02 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			//1. JDBC 드라이버 로드 
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. Connection 읽기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "member"; // 사용자 = 데이터베이스
			String password = "12345"; //
			
			con = DriverManager.getConnection(url, user, password);
			
			//3. usertbl 입력
			String sql = "insert into usertbl(userid, name, password, age, email) ";
			sql += "values(?, ?, ?, ?, ?)";
			// 4. PreParedStatement String -> SQL
			PreparedStatement ptsmt = con.prepareStatement(sql);
			
			ptsmt.setString(1, "spring");
			ptsmt.setString(2, "봄");
			ptsmt.setString(3, "12345");
			ptsmt.setInt(4, 27);
			ptsmt.setString(5, "spring@spring.com");
			
			//5. 실행
			int rows = ptsmt.executeUpdate(); //insert into문 실행
			System.out.println("입력된 회원수 " + rows);
			
			ptsmt.close();
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
	}
}
