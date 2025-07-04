package kr.co.soldesk.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.dao.UserDAO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	// UserBean의 loginUserBean객체로서 session 영역을 의미함.
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	public boolean checkuserIdExist(String user_id) {

		// 데이터 베이스에 있는 user_id와 내가 입력한 user_id를 비교.
		String user_name = userDao.checkUserIdExist(user_id);

		if (user_name == null) {
			return true;
		} else {
			return false;
		}
	}

	public void getLoginUserInfo(UserBean tempLoginUserBean) {

		// DB에 있는 유저정보.
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);

		if (tempLoginUserBean2 != null) {
			if (tempLoginUserBean.getUser_pw().equals(tempLoginUserBean2.getUser_pw())) {
				// 데이터 베이스에 있는 정보를 세션영역에 저장.
				loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
				loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
				loginUserBean.setUserLogin(true); // 로그인 성공
			}//if
			else {
				loginUserBean.setUserLogin(false);
			}
		}//if
		else {
			loginUserBean.setUserLogin(false);
		}

	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
}
