package Signin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectDB {
    private Connection con;

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
            String user = "overflow"; // 사용자 = 데이터베이스
            String password = "12345"; //

            con = DriverManager.getConnection(url, user, password);
            System.out.println("연결 성공.");
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

}
