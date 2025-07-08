package kr.co.soldesk.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soldesk.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	//로그인 여부를 판단하는 loginUserBean
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//로그인을 하지 않았다면
		if(loginUserBean.isUserLogin()==false) {
			//로그인 하지않은 경로저장
			String contextPath = request.getContextPath();
			
			response.sendRedirect(contextPath + "/user/not_login");
			
			return false;
		}
		return true;
	}
	
	
	
	
}
