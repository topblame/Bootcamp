package kr.co.soldesk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	// 비밀번호를 해시화
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private Map<String, Integer> loginFailCount = new HashMap<>();
	// 계정 잠금 시간
	private Map<String, Long> lockoutTimeMap = new ConcurrentHashMap<>();

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private static final int MAX_LOGIN_ATTEMPTS = 5; // 로그인 실패 카운터
	private static final int LOCKOUT_DURATION_MS = 5000; // 5초 잠금

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

		String userId = tempLoginUserBean.getUser_id();

		// 계정 잠금 여부 확인
		if (lockoutTimeMap.containsKey(userId)) {
			long lockoutEndTime = lockoutTimeMap.get(userId);
			if (System.currentTimeMillis() < lockoutEndTime) {
				long secondsRemaining = (lockoutEndTime - System.currentTimeMillis()) / 1000;
				throw new RuntimeException("잠시 후 다시 시도해주세요. " + secondsRemaining + "초 남았습니다.");
			} else {
				// 잠금 시간이 지나면 해제
				lockoutTimeMap.remove(userId);
				loginFailCount.put(userId, 0); // 실패 카운트 초기화
			}
		}

		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);

		if (tempLoginUserBean2 != null
				&& passwordEncoder.matches(tempLoginUserBean.getUser_pw(), tempLoginUserBean2.getUser_pw())) {
			// 로그인 성공 처리
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
			loginFailCount.put(userId, 0); // 로그인 성공 시 실패 카운트 초기화

			logger.info("로그인 성공: 사용자 ID: {}", userId);
		} else {
			// 로그인 실패 처리
			int failCount = loginFailCount.getOrDefault(userId, 0) + 1;
			loginFailCount.put(userId, failCount);

			if (failCount >= MAX_LOGIN_ATTEMPTS) {
				// 계정 잠금 설정
				lockoutTimeMap.put(userId, System.currentTimeMillis() + LOCKOUT_DURATION_MS);
				logger.error("로그인 시도가 너무 많습니다. 사용자 ID: {}", userId);
				throw new RuntimeException("로그인 시도가 너무 많습니다. 5초 후 다시 시도해주세요.");
			}

			logger.warn("로그인 실패: 사용자 ID: {}, 실패 횟수: {}", userId, failCount);
		}
	}

	// 로그인 실패 카운터 반환
	public int getFailCount(String userId) {
		return loginFailCount.getOrDefault(userId, 0);
	}

	public void addUserInfo(UserBean joinUserBean) {
		// 비번 해시 암호화 하여 DB에 저장
		String encodedPassword = passwordEncoder.encode(joinUserBean.getUser_pw());
		joinUserBean.setUser_pw(encodedPassword);
		userDao.addUserInfo(joinUserBean);
	}

	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());

		// 회원의 아이디 이름 고유번호를 modifyUserBean객체에 저장
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(tempModifyUserBean.getUser_idx());
	}

	public void modifyUserInfo(UserBean modifyUserBean) {
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		userDao.modifyUserInfo(modifyUserBean);
	}

}
