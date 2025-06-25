package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//Driver 등록 
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//DB연결 메서드
	public Connection getConnection() {
		try {
			//2. Connection 읽기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "member"; // 사용자 = 데이터베이스
			String password = "12345"; //
			
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}// getConnection
	
	//자원반납
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//try catch
	}//close
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//try catch
	}//close
	
	public UserDTO select(String userid) {
		UserDTO userDto = null;
		try {

			con = getConnection();

			String sql = "SELECT userid, name, password, age, email FROM  usertbl WHERE userid=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDto = new UserDTO();
				userDto.setUserid(rs.getString("userid"));
				userDto.setName(rs.getString("name"));
				userDto.setPassword(rs.getString("password"));
				userDto.setAge(rs.getInt("age"));
				userDto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return userDto;
	}
	
	public int delete(String userid, String password) {
		int rows = 0;
		try {
			con = getConnection();
			String sql = "delete from usertbl where userid = ? and password = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return rows;
	}
	
	public int insert(UserDTO updateDTO) {
		int rows = 0;
		
		try {
			con = getConnection();
			
			String sql = "INSERT INTO usertbl(userid, name, password, age, email) ";
			sql += "VALUES (?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateDTO.getUserid());
			pstmt.setString(2, updateDTO.getName());
			pstmt.setString(3, updateDTO.getPassword());
			pstmt.setInt(4, updateDTO.getAge());
			pstmt.setString(5, updateDTO.getEmail());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return rows;
	}
	public int update(UserDTO updateDto) {
		int rows = 0;
		try {
			con = getConnection();
			String sql = "Update usertbl set email = ? where userid = ?";
			// 4. PreParedStatement String -> SQL
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateDto.getEmail());
			pstmt.setString(2, updateDto.getUserid());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return rows;
	}
}//class
