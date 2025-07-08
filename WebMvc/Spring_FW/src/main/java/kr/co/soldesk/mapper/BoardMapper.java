package kr.co.soldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.soldesk.beans.ContentBean;

public interface BoardMapper {
	// MYSQL처럼 auto_increment가 아니기때문에 .seq 직접호출해야함.
	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before = true, resultType = int.class)
	@Insert("insert into content_table(content_idx, content_subject, content_text, content_file, \r\n"
			+ "content_writer_idx, content_board_idx, content_date) \r\n"
			+ "values(#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);

	// 게시글 이름달기.
	@Select("select board_info_name\r\n" + "from board_info_table\r\n" + "where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);

	// 게시글 보기
	@Select("select a1.content_idx, a1.content_subject, a2.user_name as content_writer_name,\r\n"
			+ "to_char(a1.content_date, 'yyyy-mm-dd') as content_date\r\n" + "from content_table a1, user_table a2\r\n"
			+ "where a1.content_writer_idx = a2.user_idx\r\n" + "and a1.content_board_idx = #{board_info_idx}\r\n"
			+ "order by a1.content_idx desc")
	List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);

	// 상세보기
	@Select("select a2.user_name as content_writer_name,\r\n"
			+ "to_char(a1.content_date, 'YYYY-MM-DD') as content_date,\r\n"
			+ "a1.content_subject, a1.content_text, a1.content_file, a1.content_writer_idx\r\n"
			+ "from content_table a1, user_table a2\r\n"
			+ "where a1.content_writer_idx = a2.user_idx and content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);

	@Update("update content_table set content_subject=#{content_subject},"
			+ "content_text = #{content_text}, content_file =#{content_file, jdbcType=VARCHAR}\r\n"
			+ "where content_idx = #{content_idx}")
	void modifyContentInfo(ContentBean modifyContentBean);

	@Delete("delete from content_table where content_idx = #{content_idx}")
	void deleteContentInfo(int content_idx);

	// 해당게시판의 전체글의 수 자져오기
	@Select("select count(*) from content_table where content_board_idx = #{content_board_idx}")
	int getContentCnt(int content_board_idx);

}
