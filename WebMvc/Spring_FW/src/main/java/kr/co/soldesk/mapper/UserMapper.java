package kr.co.soldesk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.soldesk.beans.UserBean;

public interface UserMapper {
	@Select("select user_name from user_table\r\n"
			+ "where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	@Select("select user_idx, user_name, user_pw from user_table\r\n"
			+ "where user_id = #{user_id}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	@Insert("insert into user_table(user_idx, user_name, user_id, user_pw) \r\n"
			+ "values(user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	@Select("select user_id, user_name from user_table\r\n"
			+ "where user_idx = #{user_idx}")
	UserBean getModifyUserInfo(int user_idx);
	
	@Update("Update user_table set user_pw = #{user_pw} where user_idx = #{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
}
