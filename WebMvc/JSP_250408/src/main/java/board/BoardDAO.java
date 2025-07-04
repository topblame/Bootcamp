package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt; // String-> Sql
	ResultSet rs;

	public void getCon() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/orcl");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// getConv

	// ----------------------
	// #1 전체 게시글 개수
	public int getallCount() {
		getCon();
		int count = 0;
		try {
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);

			// 쿼리 결과 받기
			rs = pstmt.executeQuery(); // sql

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	// -----------------------
	// #2 전체 게시글 가져오기

	public Vector<BoardDTO> getAllBoard(int startRow, int endRow) {
		getCon();
		Vector<BoardDTO> v = new Vector<BoardDTO>();
		try {
			// Rownum : 오라클에만 존재
			String sql = "SELECT * FROM (SELECT A.* ,Rownum Rnum FROM (SELECT * FROM board ORDER BY ref desc, re_step asc) A) WHERE Rnum >= ? and Rnum <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 오라클에서 데이터를 가져와서 DTO에 저장
				BoardDTO bean = new BoardDTO();
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				// 저장된 객체를 벡터배열방에 담기
				v.add(bean);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	// -----------------------------
	// #3. 게시글 입력(insert into)
	public void insertBoard(BoardDTO bean) {
		getCon();
		int ref = 0;
		int re_step = 1;
		int re_level = 1;
		try {
			String sql = "INSERT INTO BOARD VALUES(board_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?, 0, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());

			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // insertBoard
		// --------------------댓글--------------------
		// #8 reInsertBoard

	public void reInsertBoard(BoardDTO bean) {
		getCon();
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		try {
			// 기존 댓글의 level 높이기
            String level_sql = "UPDATE board SET re_step = re_step + 1 WHERE ref = ? AND re_step > ?";
            pstmt = con.prepareStatement(level_sql);
            pstmt.setInt(1, ref);
            pstmt.setInt(2, re_level);
            pstmt.executeUpdate();

            // 댓글 추가하기
            String sql = "INSERT INTO board (num, writer, subject, email, password, content, ref, re_step, re_level, reg_date, readcount) VALUES (board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, 0)";      
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bean.getWriter());
            pstmt.setString(2, bean.getSubject());
            pstmt.setString(3, bean.getEmail());
            pstmt.setString(4, bean.getPassword());
            pstmt.setString(5, bean.getContent());
            pstmt.setInt(6, ref); //그룹번호
            pstmt.setInt(7, re_step+1); //댓글순서
            pstmt.setInt(8, re_level+1); //댓글계층
            
            pstmt.executeUpdate();
            
            con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------상세정보-------------------
	// #4. getOneBoard(num)

	public BoardDTO getOneBoard(int num) {
		getCon();
		BoardDTO bean = new BoardDTO();
		try {
			// 게시글을 읽었다는 조회수 증가
			String countsql = "update board set readcount = readcount + 1 where num = ?";

			pstmt = con.prepareStatement(countsql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			// ---------------------

			String sql = "select *from board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	// --------------------------------------------------------
	// #5 getOneUpdateBoard
	public BoardDTO getOneUpdateBoard(int num) {
		getCon();
		BoardDTO bean = new BoardDTO();

		try {
			String sql = "select *from board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	// ----------------------------
	// #6updateboard
	public void UpdateBoard(int num, String subject, String content) {
		getCon();
		try {
			String sql = "update board set subject = ?, content = ? where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);

			pstmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------
	// #7 deleteboard
	public void deleteBoard(int num) {
		getCon();
		try {
			String sql = "delete from board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
