package Signin;

import CheckUser.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sign {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public int insert(ConnectDB connectDB, UserDTO updateDTO) {
        int rows = 0;

        try {
            con = connectDB.getConnection();

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
            connectDB.close(con, pstmt, rs);
        }
        return rows;
    }
}
