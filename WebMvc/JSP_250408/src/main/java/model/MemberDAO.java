package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO {
	//오라클 접속 
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String pass="1234";
	
	Connection con;
	PreparedStatement pstmt; //String -> sql
	ResultSet rs; // 데이터 측 결과값 리턴 받는 객체
	
	public void getCon() {
		try{
			//1.오라클 드라이버 인식(ojdbc8.jar)
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   //2.오라클 접속
		   con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}//getCon
	
	public void insertMember(MemberDTO mDTO) {
		try {
			//연동
			getCon();
			//======================insert===============================
			//String -> SQL
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mDTO.getId());
			pstmt.setString(2, mDTO.getPass1());
			pstmt.setString(3, mDTO.getPass2());
			pstmt.setString(4, mDTO.getEmail());
			pstmt.setString(5, mDTO.getGender());
			pstmt.setString(6, mDTO.getAddress());
			pstmt.setString(7, mDTO.getPhone());
			pstmt.setString(8, mDTO.getHobby());
			pstmt.setString(9, mDTO.getJob());
			pstmt.setString(10, mDTO.getAge());
			pstmt.setString(11, mDTO.getInfo());
			
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//insertmember
	
	// ------------------------------select(R) ---------------
	public Vector<MemberDTO> allSelectMember() {
		Vector<MemberDTO> v = new Vector<MemberDTO>();
		try {
			getCon();
			
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); //DB에서 회원정보 모두가져옴
			
			while(rs.next()) {
				MemberDTO bean = new MemberDTO();
				bean.setId(rs.getString(1)); //오라클 -> memberDTO
				bean.setPass1(rs.getString(2)); 
				bean.setPass2(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setHobby(rs.getString(8));
	            bean.setJob(rs.getString(9));
	            bean.setAge(rs.getString(10));
	            bean.setInfo(rs.getString(11));
				v.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	//-------------------3.select(상세정보) 1 select-------------------------------
	public MemberDTO oneSelectMember(String id) {
		MemberDTO bean = new MemberDTO();
		try {
			getCon();
			
			String sql = "select * from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //DB에서 상세정보 가져옴
			
			if(rs.next()) {
				bean.setId(rs.getString(1)); //오라클 -> memberDTO
				bean.setPass1(rs.getString(2)); 
				bean.setPass2(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setHobby(rs.getString(8));
	            bean.setJob(rs.getString(9));
	            bean.setAge(rs.getString(10));
	            bean.setInfo(rs.getString(11));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}//oneSelectMember
	
	//----------------------4. 비밀번호 일치여부 체크-------------------
	public String getPass(String id) {
		String pass = "";
		try {
			getCon();
			String sql = "select pass1 from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pass = rs.getString(1);
			}
			//해당 아디리 회원의 pass1을 select문으로 받기 => jsp에서 pass2와 비교
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pass;
	}
	// ---------------------5. 업데이트 -----------------
	public void UpdateMember(MemberDTO bean) {
		
		try {
			getCon();
			String sql = "update member set email = ?, phone = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getId());
			
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//updatemember
	
	
	
	// --------------------------6 삭제----------------------
	
	
	
	public void deleteMember(String id) {
		try {
			getCon();
			
			String sql = "Delete from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//deletemember
}
