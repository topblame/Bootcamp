package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSelect_05 {
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
			String sql = "select userid, name, password, age, email from usertbl where userid = ?";
			// 4. PreParedStatement String -> SQL
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "gabia2025");
			
			//5 실행
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				UserDTO userdto = new UserDTO();
				
				userdto.setUserid(rs.getString("userid"));
				userdto.setName(rs.getString("name"));
				userdto.setPassword(rs.getString("password"));
				userdto.setAge(rs.getInt("age"));
				userdto.setEmail(rs.getString("email"));
				
				
				System.out.println(userdto);
			}
			else {
				System.out.println("사용자 아이디가 없어");
			}
			rs.close();
			pstmt.close();
			
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
